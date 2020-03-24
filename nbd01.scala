import scala.annotation.tailrec

object s21429 {

  def zad1 (array: Array[String]) : String = {
    var result : String = "1.a: "
    //1.a
    for (d <- array) {
      result +=  d + ","
    }
    //1.b
    result += ("\n1.b: ")

    for (d <- array) {
      if (d.charAt(0).equals('P')){
        result += d + ","
      }
    }
    //1.c
    result += "\n1.c: "

    var i = 0
    while (i < array.size) {
      result += (array(i) + ",")
      i += 1
    }
    return result
  }

  def zad2a (array: Array[String] ,  string: String): String = {

    if(array.length >= 1){
      return zad2a(array.tail, string + array(0) + ",")
    }
    else{
      return string
    }
  }

  def zad2b(array: Array[String],  string: String): String = {

    if(array.length > 1){
      return zad2b(array.slice(0,array.length-1), string + array.last + ",")
    }
    else{
      return string + array.last
    }
  }

  def zad3(array: Array[String]): String = {

    @tailrec
    def ogon(array: Array[String],  string: String): String = {
      if(array.length > 1) {
        return ogon(array.tail,string + array(0) + ",")
      }
      else{
        return string + array(0)
      }
    }
    ogon(array,"3: ")
  }

  def zad4 (array: Array[String]): String = {
    var result = "4.a: "
    result += (array.foldLeft("")((acc, s) =>

      if(s.contains("Niedziela")) {
        acc + s
      }
      else {
        acc + s + ","
      }
    ))

    //4.b
    result += "\n4.b: "
    result += (array.foldRight("")((acc, s) =>
      if(s.contains("Poniedziałek")) {
        acc + s
      }
      else {
        acc + "," + s
      }
    ))
    //4.c
    result += "\n4.c: "
    result += (array.foldLeft("")((acc, s) =>
      if(s.charAt(0).==('P')) {
        acc + s + ","
      }
      else {
        acc
      }
    ))
    return result
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  def removeZero(input: List[Int], output: List[Int]): List[Int] = {

    if(input.length > 0)
    {
      if(input.head.equals(0)){
        removeZero(input.tail, output)
      }
      else{
        removeZero(input.tail, output :+ input.head)
      }
    }
    else
      return output
  }

  def raise(list: List[Int]) :List[Int] = {
    return list.map(value => value + 1)
  }

  def doTheMath(list: List[Double]) :List[Double] = {
    return list.filter(value => value >= -5 && value <= 12).map(value => value.abs)
  }

  def main(args: Array[String]): Unit ={


    var days = Array("Poniedzialek", "Wtorek", "Sroda","Czwartek","Piatek","Sobota","Niedziela")
    //1.abc
    val zadanie1 = zad1(days)
    println(zadanie1)

    //2.a
    val zadanie2a = zad2a(days, "2.a: ")
    println(zadanie2a)
    //2.b
    val zadanie2b: String = zad2b(days, "2.b: ")
    println(zadanie2b)

    //3.
    val zadanie3 = zad3(days)
    println(zadanie3)

    //4.abc
    val zadanie4 = zad4(days)
    println(zadanie4)

    //5.
    val input: Map[String, Double] = Map(("Ser" -> 5.5), ("Mleko" -> 3.1), ("Pierogi" -> 10), ("Cola" -> 3.5))
    val output = input map {case (key, value) => (key, value * 0.9)}
    println("5: " + output)

    //6.
    val piosenka = ('u' , "Makarena", 6.9)
    println("6: " + piosenka._1 + ", " + piosenka._2 + "," + piosenka._3)

    //7.
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println("7: show(capitals.get( \"Japan\")) : " + show(capitals.get( "Japan")) )
    println("   show(capitals.get( \"India\")) : " + show(capitals.get( "India")) )

    //8.
    val intList = List(1,0,2,0,3,0,4,0,5,0,6)
    val removed  = removeZero(intList, List())
    println("8: " + removed)

    //9.
    val listInput = List(1,2,3,4,5)
    println("9: " + raise(listInput))

    //10.
    val doubleList = List(-6.9, -5.0, -3.5, 4, 11.9, 13.13)
    println("10: " + doTheMath(doubleList))
  }

}