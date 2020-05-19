db.people.mapReduce(
  function () {
    emit(this.job, {
      iloscPracownikow: 1
    });
  },
  function (key, wartosci) {
    var wartoscZredukowana = {
      iloscPracownikow: 0
    };

    wartosci.forEach(function (wartosc) {
      wartoscZredukowana.iloscPracownikow += wartosc.iloscPracownikow;
    });

    return wartoscZredukowana;
  }, {
    out: "listaUnikalnychPrac"
  }
).find()
