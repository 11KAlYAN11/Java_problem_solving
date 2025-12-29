#!/bin/bash
# Helper script to compile Java files from Java_problem_solving directory
# Usage: ./compile.sh <path/to/JavaFile.java>
# Example: ./compile.sh General_Problems/Demo1.java

if [ $# -eq 0 ]; then
    echo "Usage: ./compile.sh <path/to/JavaFile.java>"
    echo "Example: ./compile.sh General_Problems/Demo1.java"
    exit 1
fi

JAVA_FILE="$1"

# Check if file exists
if [ ! -f "$JAVA_FILE" ]; then
    echo "Error: File '$JAVA_FILE' not found!"
    exit 1
fi

# Get the base directory (Java_problem_solving)
BASE_DIR=$(pwd)
SOURCE_DIR="$BASE_DIR"

# Extract package path from file
PACKAGE_LINE=$(grep "^package " "$JAVA_FILE" | head -1)
if [ -z "$PACKAGE_LINE" ]; then
    echo "Error: No package declaration found in $JAVA_FILE"
    exit 1
fi

# Get package name and convert to directory path
PACKAGE_NAME=$(echo "$PACKAGE_LINE" | sed 's/package //' | sed 's/;//' | tr -d ' ')
PACKAGE_PATH=$(echo "$PACKAGE_NAME" | tr '.' '/')

# Get the directory containing the Java file
FILE_DIR=$(dirname "$JAVA_FILE")

# Create output directory structure
OUTPUT_DIR="$BASE_DIR/out"
mkdir -p "$OUTPUT_DIR"

# Compile from source root
echo "Compiling $JAVA_FILE..."
javac -d "$OUTPUT_DIR" -sourcepath "$SOURCE_DIR" "$JAVA_FILE"

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo "  Output directory: $OUTPUT_DIR"
else
    echo "✗ Compilation failed!"
    exit 1
fi

