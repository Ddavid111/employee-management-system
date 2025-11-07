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

---

### Iterator  
A dolgozók listájának **bejárásához** használatos.  
Az `EmployeeIterator` kizárólag a bejárást valósítja meg, és az `ListIterator` interfészen keresztül függetleníti a bejárási logikát a konkrét tárolótól.  
Az aggregáló műveletek — például az **átlagéletkor számítása** — külön komponensben, az `EmployeeAggregator` osztályban valósulnak meg, amely az iterátort használja az adatok feldolgozásához.

Ezáltal az algoritmusok **függetlenek az adatszerkezettől**, és más bejáróval vagy más típusú kollekcióval is működhetnek.

---

### Proxy  
A fájlműveletek (beolvasás, írás) kezelését végzi és **naplózza** a műveleteket.  
A `FileServiceProxy` továbbítja a kéréseket a valódi `EmployeeFileService` felé, miközben ellenőrzéseket és naplózást végez a műveletek előtt és után.

Ez a megoldás jól szemlélteti, hogyan egészíthető ki egy meglévő szolgáltatás új viselkedéssel a **Proxy minta** segítségével, anélkül, hogy módosítanánk az eredeti osztály kódját.

---
