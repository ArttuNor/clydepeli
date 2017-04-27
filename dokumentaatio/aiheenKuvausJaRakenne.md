**Aihe:** Vuoropohjainen roolipeli Toteutetaan pienimuotoinen peli, jossa pelaaja valitsee eri vaihtoehdoista erilaisia "hyökkäyksiä", ja pyrkii siten voittamaan vastustajia. Vastustajia tulee vastaan niin kauan kuin pelaaja selviää. Eri "hyökkäyksillä" on erilaisia ominaisuuksia, ja hahmoilla saattaa olla heikkous tai vahvuus näille ominaisuuksille.

Pelissä voi ostaa esineitä kaupasta, joka avautuu muutaman taistelun välein. Pelaaja saa ostoksiinsa rahaa kaupasta.

**Käyttäjät:** Pelaaja

**Käyttäjän toiminnot:**

* Valikkojen hallinta
* Itse pelitilanne, eli hyökkäyksien valitseminen
* Esineiden ostaminen
* Esineiden käyttäminen

**Rakennekuvaus**

Pelin perustana ovat Hahmo-oliot, joilla on hyökkäyksinä Hyökkäys-olioita. Hahmot vaikuttavat toisiinsa Taistelu-olioiden kautta. Pelissä
on lisäksi Esine-olioita, joiden avulla voi vaikuttaa hahmoihin. Esineitä saa Kauppa-olioista.

Lisäksi pelissä on kohtuullinen joukko käyttöliittymäluokkia, sekä ActionListener-luokkia, jotka pyörittävät pelin käyttöliittymää.

![Alt text](https://github.com/ArttuNor/miscfiles/blob/master/clydepeliluokkakaavio2.jpg "Luokkakaavio")
![Alt text](https://github.com/ArttuNor/miscfiles/blob/master/clydepelisekvenssikaavio1.jpg "Sekvenssikaavio 1: Uuden pelin aloittaminen")
![Alt text](https://github.com/ArttuNor/miscfiles/blob/master/clydepelisekvenssikaavio2.jpg "Sekvenssikaavio 2: Ohjeiden lukeminen")
