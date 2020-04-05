import sun.nio.ch.FileKey

import scala.annotation.tailrec

object nbd02 {

  def main(args: Array[String]): Unit ={

    //1
    println("1. Poniedzialek => " + zad1("Poniedzialek"))
    println("   czWaRtEk => " + zad1("czWaRtEk"))
    println("   sobota => " + zad1("sobota"))
    println("   Wozkreszenie => " + zad1("Wozkreszenie"))

    //2
    println("2. akcja : saldo")
    zad2()

    //3
    zad03()
//    var kontoBankowe : KontoBankowe = new KontoBankowe(30)
//    var kontoBankowe2 : KontoBankowe = new KontoBankowe()
//    println(kontoBankowe.saldoPocz, kontoBankowe2.saldoPocz)

    //4
    println("4. ((5*2)*2)*2 => " + zad04(5)(multiply))

    //5

    var student = new Student {}
    var pracownik = new Pracownik {}
    pracownik.pensja = 3000
    var nauczyciel = new Nauczyciel {}
    nauczyciel.pensja = 3000
    println("5. Student podatek: " + student.podatek)
    println("   Pracownik podatek: " + pracownik.podatek)
    println("   Nauczyciel podatek: " + nauczyciel.podatek)
    println("   Pracownik pensja: " + pracownik.pensja)
    println("   Nauczyciel pensja: " + nauczyciel.pensja)


  }

  def zad1(day: String): String = day.toLowerCase match {
    case "poniedzialek" => "Praca"
    case "wtorek" => "Praca"
    case "sroda" => "Praca"
    case "czwartek" => "Praca"
    case "piatek" => "Praca"
    case "sobota" => "Weekend"
    case "niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  def zad2(): Unit ={
    var pusteKonto = new KontoBankowe
    var pelneKonto = new KontoBankowe(1000)
    println("   Poczatkowy stan konta pustego: " + pusteKonto._stanKonta)
    println("   Poczatkowy stan konta pelnego: " + pelneKonto._stanKonta)
    pusteKonto.wplata(100)
    println("   Wplata na koto puste 100zl: " + pusteKonto._stanKonta)
    pusteKonto.wyplata(101)
    println("   Wyplata z konta pustego 101zl: " + pusteKonto._stanKonta)
    pelneKonto.wyplata(101)
    println("   Wyplata z konta pelnego 101 zl: " + pelneKonto._stanKonta)

  }

   class KontoBankowe(val saldoPocz :Float) {
    private var stanKonta :Float = saldoPocz

      def this(){
      this(0)
    }

    def _stanKonta = stanKonta

    def wplata(ile :Float): Unit = {
      stanKonta += ile
    }

    def wyplata(ile :Float): Unit = {
      if (ile <= stanKonta) stanKonta -= ile else println("   Nie ma opcji kolego")
    }

  }

  def zad03(): Unit = {
    val osoba1 = Osoba("Krystian", "Dajewski")
    val osoba2 = Osoba("Marek", "Aureliusz")
    val osoba3 = Osoba("Albert", "Hillner")
    val osoba4 = Osoba("Andriej", "Dupa")

    print("3. ")
    println(przywitaj(osoba1))
    println(przywitaj(osoba2))
    println(przywitaj(osoba3))
    println(przywitaj(osoba4))

  }

  def przywitaj(osoba: Osoba) :String={
    osoba.imie match {
      case "Krystian" => s"Poranne patrzenie w lustro be like: ${osoba.imie}"
      case "Marek" => s"   Czesc ${osoba.imie}!"
      case "Albert" => s"   Heil ${osoba.imie}!"
      case _ => "   Nie poznano pana prezydenta"
    }
  }

  case class Osoba(imie :String, nazwisko :String)


  def multiply(x : Int, y : Int): Int = {
    if (y>0) {
      val z:Int=y-1
      multiply(x*2, z)
    }
    else x
  }

  def zad04(x : Int)(f: (Int,Int) => Int): Int = {
    f(x,3)
  }

   abstract class Osoba2 {
    private var _imie : String = "Kwiat"
    private val _nazwisko : String = "Jabłoni"
    private var _podatek : Double = 1

    def imie = _imie
    def nazwisko = _nazwisko
    def podatek = _podatek
  }

  class Student extends Osoba2 {
    override def podatek: Double = 0
  }

  trait Pracownik extends Osoba2 {
    private var _pensja : Double = 0

    def pensja = _pensja
    def pensja_= (nowaPensja : Double) = _pensja = nowaPensja * podatek

    override def podatek: Double = 0.8
  }

  trait Nauczyciel extends Pracownik {
    override def podatek: Double = 0.9
  }





}