#!/usr/bin/env python3
"""
Script to add simple package declarations that match directory names.
This prevents class name conflicts without requiring directory restructuring.
"""

import os
from pathlib import Path

def get_simple_package_name(file_path):
    """Get simple package name based on directory structure."""
    parts = Path(file_path).parts
    
    try:
        idx = parts.index('Java_problem_solving')
        relative_parts = parts[idx + 1:-1]  # Exclude filename
    except ValueError:
        relative_parts = Path(file_path).parent.parts
    
    if not relative_parts:
        # Root files - use "basics" or no package
        return "basics"
    
    # Use directory name as package (keep original case)
    return relative_parts[-1]

def update_package_declaration(file_path):
    """Update or add simple package declaration."""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        lines = content.split('\n')
        simple_package = get_simple_package_name(file_path)
        updated = False
        
        # Find existing package declaration
        pkg_idx = -1
        for i, line in enumerate(lines):
            stripped = line.strip()
            if stripped.startswith('package '):
                pkg_idx = i
                old_package = stripped.replace('package ', '').replace(';', '').strip()
                # Check if package needs updating
                needs_update = False
                
                # Always update if it has com.learning.java prefix
                if old_package.startswith('com.learning.java.'):
                    needs_update = True
                # Or if package doesn't match
                elif old_package != simple_package:
                    needs_update = True
                
                if needs_update:
                    lines[i] = f"package {simple_package};"
                    updated = True
                    print(f"✓ Updated {file_path}: {old_package} -> {simple_package}")
                else:
                    print(f"  {file_path} already has correct package: {simple_package}")
                break
        
        # If no package found, add one
        if pkg_idx == -1:
            # Find where to insert (after comments, before imports)
            insert_idx = 0
            for i, line in enumerate(lines):
                stripped = line.strip()
                if stripped.startswith('//') or stripped.startswith('/*') or stripped.startswith('*') or not stripped:
                    continue
                if stripped.startswith('import '):
                    insert_idx = i
                    break
                insert_idx = i
                break
            
            lines.insert(insert_idx, f"package {simple_package};")
            if insert_idx + 1 < len(lines) and lines[insert_idx + 1].strip():
                lines.insert(insert_idx + 1, '')
            updated = True
            print(f"✓ Added package {simple_package} to {file_path}")
        
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
    
    print(f"Fixing packages for {len(java_files)} Java files...")
    print("Using simple package names that match directory names")
    print("=" * 60)
    
    updated_count = 0
    
    for java_file in sorted(java_files):
        if 'build' in str(java_file) or 'target' in str(java_file):
            continue
            
        if update_package_declaration(java_file):
            updated_count += 1
    
    print("=" * 60)
    print(f"Summary: {updated_count} files updated")
    print("\nNote: Java package names don't require matching directories!")
    print("This simple approach prevents conflicts while keeping your directory structure.")

if __name__ == '__main__':
    main()

