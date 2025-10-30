# employee-management-system

## Leírás

Ez a program egy **dolgozói nyilvántartó rendszert** valósít meg, amely kétféle dolgozót kezel:  
**egyetemi (UniEmployee)** és **informatikai (ITEmployee)** munkavállalókat.  
A rendszer képes a dolgozók adatait **fájlba menteni, onnan visszaolvasni**, valamint **listák formájában bejárni és feldolgozni** az adatokat.

A kód Java nyelven készült, és több **programtervezési mintát** is alkalmaz a kód strukturáltsága és bővíthetősége érdekében.

Alkalmazott tervezési minták

### Factory Method
Az új dolgozók létrehozásáért felel.  
A `EmployeeFactoryImpl` dönti el, hogy `ITEmployee` vagy `UniEmployee` példányt kell létrehozni a megadott munkahely alapján.

### Iterator
A dolgozók listájának bejárásához.  
Az `EmployeeIterator` segítségével egységesen lehet végigmenni a dolgozókon, függetlenül azok típusától.

### Facade
A fájlműveletek (beolvasás és írás) egyszerűsített kezeléséhez.  
Az `EmployeeFileService` biztosítja, hogy a fájlkezelés logikája el legyen rejtve a főprogram elől, így az `App` osztályból könnyen használható.
