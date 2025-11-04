# employee-management-system

## Leírás

Ez a program egy **dolgozói nyilvántartó rendszert** valósít meg, amely kétféle dolgozót kezel:  
**egyetemi (UniEmployee)** és **informatikai (ITEmployee)** munkavállalókat.  
A rendszer képes a dolgozók adatait **fájlba menteni, onnan visszaolvasni**, valamint **listák formájában bejárni és feldolgozni** az adatokat.

A kód Java nyelven készült, és több **programtervezési mintát** is alkalmaz a kód strukturáltsága és bővíthetősége érdekében.

---

## Alkalmazott tervezési minták

### Factory Method  
Az új dolgozók létrehozásáért felel.  
A `EmployeeFactoryImpl` dönti el, hogy `ITEmployee` vagy `UniEmployee` példányt kell létrehozni a megadott munkahely alapján.

### Iterator (Analyzer Iterator)  
A dolgozók listájának bejárásához és feldolgozásához.  
Az `EmployeeIterator` nemcsak bejárja a dolgozók listáját, hanem **átlagéletkort is számol** az adott csoportban.

### Proxy  
A fájlműveletek (beolvasás, írás) kezelését végzi és **naplózza** a műveleteket.  
A `FileServiceProxy` továbbítja a kéréseket a valódi `EmployeeFileService` felé, miközben kijelzi például, hány dolgozó adatát írta vagy olvasta be.

---
