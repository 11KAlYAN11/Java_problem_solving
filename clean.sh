#!/bin/bash
# Script to clean all compiled .class files
# Usage: ./clean.sh

echo "Cleaning compiled files..."

# Remove out directory
if [ -d "out" ]; then
    rm -rf out
    echo "✓ Removed 'out' directory"
fi

# Find and remove all .class files recursively
find . -name "*.class" -type f -delete 2>/dev/null
if [ $? -eq 0 ]; then
    echo "✓ Removed all .class files"
else
    echo "  No .class files found"
fi

echo "Cleanup complete!"

