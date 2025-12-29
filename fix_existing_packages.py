#!/usr/bin/env python3
"""
Script to standardize existing package declarations to use com.learning.java prefix.
"""

import os
import re
from pathlib import Path

def get_standard_package_name(file_path):
    """Convert file path to standard package name."""
    parts = Path(file_path).parts
    
    try:
        idx = parts.index('Java_problem_solving')
        relative_parts = parts[idx + 1:-1]
    except ValueError:
        relative_parts = Path(file_path).parent.parts
    
    if not relative_parts:
        return "com.learning.java.basics"
    
    package_parts = []
    for part in relative_parts:
        part = part.replace('-', '_').replace(' ', '_')
        if part and part[0].isalpha():
            package_parts.append(part.lower())
    
    if package_parts:
        return "com.learning.java." + ".".join(package_parts)
    else:
        return "com.learning.java.basics"

def update_package_declaration(file_path):
    """Update package declaration to standard format."""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        lines = content.split('\n')
        standard_package = get_standard_package_name(file_path)
        updated = False
        
        for i, line in enumerate(lines):
            stripped = line.strip()
            if stripped.startswith('package '):
                old_package = stripped.replace('package ', '').replace(';', '').strip()
                if old_package != standard_package:
                    lines[i] = f"package {standard_package};"
                    updated = True
                    print(f"✓ Updated {file_path}: {old_package} -> {standard_package}")
                else:
                    print(f"  {file_path} already has correct package")
                break
        
        if updated:
            new_content = '\n'.join(lines)
            with open(file_path, 'w', encoding='utf-8') as f:
                f.write(new_content)
            return True
        
        return False
        
    except Exception as e:
        print(f"✗ Error processing {file_path}: {e}")
        return False

def main():
    """Main function."""
    base_dir = Path(__file__).parent
    java_files = list(base_dir.rglob('*.java'))
    
    print(f"Processing {len(java_files)} Java files to standardize packages...")
    print("=" * 60)
    
    updated_count = 0
    
    for java_file in sorted(java_files):
        if 'build' in str(java_file) or 'target' in str(java_file):
            continue
            
        if update_package_declaration(java_file):
            updated_count += 1
    
    print("=" * 60)
    print(f"Summary: {updated_count} files updated")

if __name__ == '__main__':
    main()

