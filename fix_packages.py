#!/usr/bin/env python3
"""
Script to add package declarations to Java files based on their directory structure.
This fixes package conflicts and source path issues.
"""

import os
import re
from pathlib import Path

def get_package_name(file_path):
    """Convert file path to package name."""
    # Get relative path from Java_problem_solving directory
    parts = Path(file_path).parts
    
    # Find the index of 'Java_problem_solving' in the path
    try:
        idx = parts.index('Java_problem_solving')
        # Get parts after Java_problem_solving
        relative_parts = parts[idx + 1:-1]  # Exclude filename
    except ValueError:
        # If not found, try to get from current directory structure
        relative_parts = Path(file_path).parent.parts
    
    if not relative_parts:
        # Files in root directory
        return "com.learning.java.basics"
    
    # Convert directory names to package format
    package_parts = []
    for part in relative_parts:
        # Clean directory names (remove special chars, make valid Java identifier)
        part = part.replace('-', '_').replace(' ', '_')
        # Convert to camelCase or keep as is
        if part and part[0].isalpha():
            package_parts.append(part.lower())
    
    if package_parts:
        return "com.learning.java." + ".".join(package_parts)
    else:
        return "com.learning.java.basics"

def has_package_declaration(content):
    """Check if file already has a package declaration."""
    # Remove comments and whitespace to check for package
    lines = content.split('\n')
    for line in lines:
        stripped = line.strip()
        if stripped.startswith('package '):
            return True, stripped
        if stripped and not stripped.startswith('//') and not stripped.startswith('/*') and not stripped.startswith('*'):
            break
    return False, None

def add_package_declaration(file_path):
    """Add package declaration to a Java file if it doesn't have one."""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        has_pkg, existing_pkg = has_package_declaration(content)
        
        if has_pkg:
            print(f"✓ {file_path} already has package: {existing_pkg}")
            return False
        
        package_name = get_package_name(file_path)
        
        # Find where to insert the package declaration
        lines = content.split('\n')
        insert_idx = 0
        
        # Skip leading comments and blank lines
        for i, line in enumerate(lines):
            stripped = line.strip()
            if stripped.startswith('//') or stripped.startswith('/*') or stripped.startswith('*') or not stripped:
                continue
            if stripped.startswith('package ') or stripped.startswith('import '):
                continue
            insert_idx = i
            break
        
        # Insert package declaration
        package_line = f"package {package_name};"
        lines.insert(insert_idx, package_line)
        
        # Ensure blank line after package
        if insert_idx + 1 < len(lines) and lines[insert_idx + 1].strip():
            lines.insert(insert_idx + 1, '')
        
        new_content = '\n'.join(lines)
        
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(new_content)
        
        print(f"✓ Added package {package_name} to {file_path}")
        return True
        
    except Exception as e:
        print(f"✗ Error processing {file_path}: {e}")
        return False

def main():
    """Main function to process all Java files."""
    base_dir = Path(__file__).parent
    java_files = list(base_dir.rglob('*.java'))
    
    print(f"Found {len(java_files)} Java files")
    print("=" * 60)
    
    updated_count = 0
    skipped_count = 0
    
    for java_file in sorted(java_files):
        # Skip files in subdirectories that might be build outputs
        if 'build' in str(java_file) or 'target' in str(java_file):
            continue
            
        if add_package_declaration(java_file):
            updated_count += 1
        else:
            skipped_count += 1
    
    print("=" * 60)
    print(f"Summary: {updated_count} files updated, {skipped_count} files already had packages")

if __name__ == '__main__':
    main()

