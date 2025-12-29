# Java Problem Solving Repository - Usage Guide

## ✅ Repository Restructured!

This repository has been restructured to fix package conflicts and source path issues. All Java files now have proper package declarations based on their directory structure.

## 📁 Package Structure

All packages follow the naming convention: `com.learning.java.<category>`

Examples:
- Root files → `com.learning.java.basics`
- `Collections/` → `com.learning.java.collections`
- `OOPS/` → `com.learning.java.oops`
- `General_Problems/` → `com.learning.java.general_problems`
- `Streams/` → `com.learning.java.streams`
- etc.

## 🚀 How to Compile and Run Files

### Method 1: Using Helper Scripts (Recommended)

#### Compile a file:
```bash
cd /home/pavan/javaPS/Java_problem_solving
./compile.sh General_Problems/Demo1.java
```

#### Compile and Run a file:
```bash
./run.sh General_Problems/Demo1.java
```

#### Run with arguments:
```bash
./run.sh General_Problems/Demo1.java arg1 arg2
```

#### Clean all compiled files:
```bash
./clean.sh
```

### Method 2: Manual Compilation

#### Step 1: Navigate to the repository root
```bash
cd /home/pavan/javaPS/Java_problem_solving
```

#### Step 2: Compile the file
```bash
javac -d out -sourcepath . General_Problems/Demo1.java
```

#### Step 3: Run the compiled class
```bash
java -cp out com.learning.java.general_problems.Demo1
```

## 📝 Important Notes

1. **All files now have packages**: Every Java file has a proper package declaration matching its directory structure.

2. **No more conflicts**: Files in different directories have different packages, so there are no more class name conflicts.

3. **Compiled files location**: All `.class` files are compiled to the `out/` directory (or use the helper scripts).

4. **Clean before compiling**: If you encounter issues, run `./clean.sh` to remove all compiled files.

5. **.gitignore**: The repository now includes a `.gitignore` file to exclude `.class` files from version control.

## 🔧 Troubleshooting

### Issue: "package does not exist"
- Make sure you're compiling from the repository root (`Java_problem_solving/`)
- Use `-sourcepath .` when compiling
- Use `-d out` to specify output directory

### Issue: "class not found"
- Make sure the compiled `.class` file is in the `out/` directory
- Use the full package name when running: `com.learning.java.package.ClassName`
- Check that you're using `-cp out` when running

### Issue: "duplicate class" errors
- Some packages intentionally have duplicate class names for learning (e.g., `Car` appears in multiple files)
- Compile files separately, not together
- Run `./clean.sh` to remove all compiled files
- Recompile only the specific file you need

### Issue: "cannot find symbol" for classes in same package
- Some files depend on other classes in the same package
- Compile all related files together: `javac -d out -sourcepath . <file1> <file2> ...`
- See `COMPILE_GUIDE.md` for detailed examples

## 📚 Example Workflow

```bash
# 1. Clean any old compiled files
./clean.sh

# 2. Run a simple file
./run.sh Hello.java

# 3. Run a file in a subdirectory
./run.sh General_Problems/Demo1.java

# 4. Run an OOPS example
./run.sh OOPS/AnimalCatDogMain.java
```

## 🎯 Benefits of This Structure

✅ **No more package conflicts** - Each file has a unique package  
✅ **No source path issues** - Proper package structure  
✅ **Easy to compile** - Helper scripts handle everything  
✅ **Clean repository** - `.class` files excluded from git  
✅ **Scalable** - Easy to add new files without conflicts  

---

Happy Coding! 🎉

