# DateParser

This utility tries to parse date time.

Current Supported formats:
```
yyyy-MM-dd 
yyyy-MM-dd HH:mm
yyyy-MM-dd hh:mm 
yyyy-MM-dd hh:mm a
yyyy-MM-dd HH:mm:ss
yyyy-MM-dd hh:mm:ss
yyyy-MM-dd hh:mm:ss a


MM-dd-yyyy 
MM-dd-yyyy HH:mm
MM-dd-yyyy hh:mm 
MM-dd-yyyy hh:mm a
MM-dd-yyyy HH:mm:ss
MM-dd-yyyy hh:mm:ss
MM-dd-yyyy hh:mm:ss a

dd-MM-yyyy 
dd-MM-yyyy HH:mm
dd-MM-yyyy hh:mm 
dd-MM-yyyy hh:mm a
dd-MM-yyyy HH:mm:ss
dd-MM-yyyy hh:mm:ss
dd-MM-yyyy hh:mm:ss a

MM/dd/yyyy 
MM/dd/yyyy HH:mm
MM/dd/yyyy hh:mm 
MM/dd/yyyy hh:mm a
MM/dd/yyyy HH:mm:ss
MM/dd/yyyy hh:mm:ss
MM/dd/yyyy hh:mm:ss a

dd/MM/yyyy 
dd/MM/yyyy HH:mm
dd/MM/yyyy hh:mm 
dd/MM/yyyy hh:mm a
dd/MM/yyyy HH:mm:ss
dd/MM/yyyy hh:mm:ss
dd/MM/yyyy hh:mm:ss a

MMM dd, yyyy 
MMM dd, yyyy HH:mm
MMM dd, yyyy hh:mm 
MMM dd, yyyy hh:mm a
MMM dd, yyyy HH:mm:ss
MMM dd, yyyy hh:mm:ss
MMM dd, yyyy hh:mm:ss a
```
* y – Year (1996; 96)
* M – Month in year (July; Jul; 07)
* d – Day in month (1-31)
* a – AM/PM marker (AM, PM)
* H – Hour in day (0-23)
* h – Hour in AM/PM (1-12)
* m – Minute in hour (0-60)
* s – Second in minute (0-60)


### Usage Example
```
DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022",false, false);
String dateFormat = dateWithFormat.getFormat(); 
//MMM dd, yyyy
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
simpleDateFormat.format(dateWithFormat.getDate());
//2022-03-22 00:00:00
```


```
DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 23:22",false, false);
String dateFormat = dateWithFormat.getFormat(); 
//MMM dd, yyyy HH:mm
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
simpleDateFormat.format(dateWithFormat.getDate());
//2022-03-22 23:22:00
```
