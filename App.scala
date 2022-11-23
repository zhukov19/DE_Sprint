package org.example
import scala.collection.mutable.ListBuffer
import jdk.nashorn.internal.runtime.options.KeyValueOption

import Ordering.Implicits._


/**
 * @author ${user.name}
 */
object App {

 def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

 def main(args: Array[String]) {
  //val startValString = "reverse"
  var startVarString = "Hello Scala!"
  //println( startVarString)
  //3a
  println(startVarString.reverse)
  println(startVarString.toLowerCase())
  println(startVarString.init)
  println(startVarString.init + " and goodbye python!")
   //3b
  println("Введите годовой доход")
  val yearSalary = readLine().toFloat
  println("Размер премии в процентах от годового дохода")
  val bonus = readLine().toFloat
  println("Размер компенсации питания")
  val eatСompensation = readLine().toFloat
  var oklad = ((yearSalary - (yearSalary*(bonus/100)) - eatСompensation)*0.87)/12
  println(oklad)

  //val firstList = List(100, 150, 200, 80, 120, 75)
  //val commonSalary = firstList.sum
  //val countPersons = firstList.size
  //val sum = commonSalary / countPersons
  //println(sum)
  //3c
  var Employees = scala.collection.mutable.Map[Char, Double]('a' -> 100.0, 'b' -> 150.0, 'c' -> 200.0, 'd' -> 80.0, 'e' -> 120.0, 'f' -> 75.0)
  Employees += ('g' -> oklad)
  var sum: Double = 0
  for ((key, value) <- Employees) sum += value
  var mid: Double = sum / Employees.size
  println(f"\nОтклонение от среднего значение оклада $mid%.3f:")
  for ((key, value) <- Employees) {
   val otkl = (value - mid) / mid * 100
   println(f"$key : $otkl%.3f %% \t($value)")

  }
  //3d
  val shtraf = 10
  println("Введите зарплату провинившегося сотрудника")
  val salary_bad_employes = readLine().toFloat
  for ((key, value) <- Employees) {
   if (salary_bad_employes == value) {
    val new_salary_bademp = salary_bad_employes - shtraf
    println(s"Зарплата оштрафованнного сотрудника = ${new_salary_bademp}")
   }
   else {
    println("Зарплата остается прежней")
   }
  }
  println(s"Самая высокая зарплата =  ${Employees.values.max}")
  println(s"Самая низкая зарплата =  ${Employees.values.min}")

//3e
  println("Добавили сотрудников с окладами 350 и 90 тысяч.")
  Employees += ('h' -> 350)
  Employees += ('i' -> 90)
  var Employees1 = Employees.toSeq.sortBy(_._2)
  for (i <- Employees1.iterator) println(i)
//3f
  println("Добавили сотрудника с окладом 130 тысяч.")
  Employees += ('n' -> 130)
  var Employees2 = Employees.toSeq.sortBy(_._2)
  for (i <- Employees2.iterator) println(i)

//3g
var listEmployees = ListBuffer[Double](100,150,200,80,120,75,350,90,130)
  var middleSalMin = 100
  var middleSalMax = 200
  println("индексы сотрудников уровня middle: ")
  for (i <- 0 until listEmployees.size) if ((listEmployees(i) <= middleSalMax) && (listEmployees(i) >= middleSalMin)) println(f"$i ")

//3h
  println()
  println("Проиндексированные на 7% оклады:")
  listEmployees = listEmployees.map(value => value * 1.07)
  for (value <- listEmployees) println(f"$value%.3f")
 }


  }





