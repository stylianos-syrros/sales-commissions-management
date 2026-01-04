# Sales Commissions Application

A Java Swing desktop application for managing sales receipts, calculating total sales, item-based sales, and sales commissions.  
The application supports importing receipts, displaying aggregated results, and exporting reports to **TXT** and **XML** formats.

---

## Features
- Add sales receipts manually via GUI
- Calculate:
  - Total sales value
  - Total number of items sold
  - Sales per category:
    - Shirts
    - Skirts
    - Trousers
    - Coats
  - Sales commission based on total sales
- Export results to:
  - TXT report
  - XML report
- Automatic creation of output folder (`Reports`) in the user's home directory

---

## Test Input Files

For easy testing, the repository includes **two ready-made test files** located in:

```
sales-commissions-application/test_input_files/
```

### Included files
- **test-case-1-TXT.txt**  
  Sample TXT input file with sales receipts.

- **test-case-2-XML.xml**  
  Sample XML input file with the same data structure.

These files can be loaded directly into the application to verify correct parsing, calculations, and report generation.

---

## Output

When exporting reports:
- Files are saved automatically in:
  ```
  <user_home>/Reports/
  ```
- File names follow the format:
  - TXT: `<AFM>_SALES.txt`
  - XML: `<AFM>_SALES.xml`

A confirmation dialog shows the **exact file path** after successful export.

---

## Technologies Used
- Java
- Java Swing (GUI)
- File I/O
- XML Processing

---

## Notes
- Item categories are case-sensitive and must be exactly:
  - `Shirts`
  - `Skirts`
  - `Trousers`
  - `Coats`
- The application recalculates all values dynamically based on the receipts added.

---

## Author
Developed as part of a Software Development II academic project.
