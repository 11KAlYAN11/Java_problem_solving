# Simple Package Structure - Usage Guide

## ✅ What Changed

All Java files now have **simple package names that match their directory names**:

- Root files → `package basics;`
- `Algorithms/` → `package Algorithms;`
- `Collections/` → `package Collections;`
- `OOPS/` → `package OOPS;`
- `General_Problems/` → `package General_Problems;`
- etc.

## 🎯 Why This Works

**No directory restructuring needed!** Java packages don't require the directory structure to match when you:
- Compile with `-sourcepath .` (finds files in your current structure)
- Use `-d out` to put compiled classes in output directory
- Files stay in their current locations

This prevents class name conflicts while keeping your simple directory structure.

## 🚀 How to Use

### Quick Run
```bash
./run.sh Hello.java
./run.sh Algorithms/SlidingWindowTechniqueEx.java
./run.sh General_Problems/Demo1.java
```

### Manual Compilation
```bash
# Compile
javac -d out -sourcepath . Hello.java

# Run
java -cp out basics.Hello
```

## 📁 Your Structure Stays the Same

```
Java_problem_solving/
├── Hello.java              → package basics;
├── Algorithms/
│   └── SlidingWindow...    → package Algorithms;
├── Collections/
│   └── Comparator...       → package Collections;
└── General_Problems/
    └── Demo1.java          → package General_Problems;
```

**No need to create com/java/learning/java/... directories!**

## ✅ Benefits

- ✅ Simple package names (match directory names)
- ✅ No directory restructuring needed
- ✅ Prevents class name conflicts
- ✅ Easy to understand and maintain
- ✅ Works with your existing workflow

## 🧹 Cleanup

```bash
./clean.sh  # Removes all compiled .class files
```

