#!/bin/bash
# Helper script to compile and run Java files from Java_problem_solving directory
# Usage: ./run.sh <path/to/JavaFile.java> [arguments]
# Example: ./run.sh General_Problems/Demo1.java

if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <path/to/JavaFile.java> [arguments]"
    echo "Example: ./run.sh General_Problems/Demo1.java"
    exit 1
fi

JAVA_FILE="$1"
shift  # Remove first argument, rest are program arguments
ARGS="$@"

# Check if file exists
if [ ! -f "$JAVA_FILE" ]; then
    echo "Error: File '$JAVA_FILE' not found!"
    exit 1
fi

# Get the base directory
BASE_DIR=$(pwd)
SOURCE_DIR="$BASE_DIR"
OUTPUT_DIR="$BASE_DIR/out"

# Extract package name from file
PACKAGE_LINE=$(grep "^package " "$JAVA_FILE" | head -1)
if [ -z "$PACKAGE_LINE" ]; then
    echo "Error: No package declaration found in $JAVA_FILE"
    exit 1
fi

PACKAGE_NAME=$(echo "$PACKAGE_LINE" | sed 's/package //' | sed 's/;//' | tr -d ' ')

# Get class name (filename without extension)
CLASS_NAME=$(basename "$JAVA_FILE" .java)

# Create output directory
mkdir -p "$OUTPUT_DIR"

# Get directory of the Java file
FILE_DIR=$(dirname "$JAVA_FILE")

# Compile - use -sourcepath to handle dependencies automatically
echo "Compiling $JAVA_FILE..."
# javac will automatically find dependencies through -sourcepath
javac -d "$OUTPUT_DIR" -sourcepath "$SOURCE_DIR" "$JAVA_FILE"

if [ $? -ne 0 ]; then
    echo "✗ Compilation failed!"
    exit 1
fi

# Run
FULL_CLASS_NAME="$PACKAGE_NAME.$CLASS_NAME"
echo "Running $FULL_CLASS_NAME..."
echo "----------------------------------------"
java -cp "$OUTPUT_DIR" "$FULL_CLASS_NAME" $ARGS

