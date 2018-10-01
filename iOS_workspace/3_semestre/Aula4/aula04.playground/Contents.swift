import Foundation

//ENUMERADORES
enum Compass {
    case north
    case south
    case east
    case west
}

var heading: Compass = Compass.north
//ou posso escrever dessa maneira: var heading: Compass = .north

switch heading {
case .north:
    print("Você está indo para o norte.")
case .south:
    print("Você está indo para o sul.")
case .east:
    print("Você está indo para o leste")
case .west:
    print("Você está indo para o oeste")
}

switch heading {
case .north:
    print("Você está indo para o norte.")
case .south:
    print("Você está indo para o sul.")
case .east:
    print("Você está indo para o leste")
default:
    print("Direcao desconhecida")
}

var speed = 110.0

switch speed {
case 0.0..<20.0:
    print("Primeira marcha")
case 20.0..<40.0:
    print("Segunda marcha")
case 40.0..<90.0:
    print("Terceira marcha")
case 90.0..<120.0:
    print("Quarta marcha")
default:
    print("Quinta marcha")
}

var letter = "j"

switch letter {
case "a"..."m":
    print("A letra encontra-se na primeira parte do alfabeto")
default:
    print("A letra encontra-se na segunda parte do alfabeto")
}

print(heading)

enum WeekDay: String {
    case syunday = "Domingo"
    case monday = "Segunda"
    case tuesday = "Terça"
    case wednesday = "Quarta-Feira"
    case thrusday = "Quinta-Feira"
    case friday = "Sexta-Feira"
    case saturday = "Sabado"
}

var today = WeekDay.friday

print("Hoje é \(today.rawValue)")

enum Measure {
    case age(UInt)
    case weight(Double)
    case size(width: Double, height: Double)
}

var measure: Measure = .size(width: 30.0, height: 45.5)

switch measure {
case .age(let age):
    print("sua idade é \(age) anos")
case .weight(let peso):
    print("o seu peso é \(peso)")
case .size(let size):
    print("Tamanho: \(size.width) x \(size.height)")
}

//STRUCT (eh um tipo por valor (copia)

struct Driver {
    
    var name: String
    var age: Int
    var cnh: String
    
}

var driver: Driver = Driver(name: "Joao", age: 30, cnh: "05248966")

var driver2 = driver
driver2.name = "Joao zinhuuu"

print(driver.name)
print(driver2.name)

//FUNCOES

func doSomething() {
    print("Fiz algo")
}

//funcao com nome externo (to)
func sayHello(to name: String) {
    print("Ola \(name)")
}

sayHello(to: "Joao Carlos")

var eric: Driver = Driver(name: "Eric Paulo", age: 28, cnh: "6554489")

//funcao sem nome externo
func registrerDriver(_ driver: Driver) {
    
}

registrerDriver(eric)

func sum(_ a: Int, _ b: Int) {
    print(a + b)
}

sum(10, 20)

func sum2(_ a: Int, _ b: Int) -> Int {
    return a + b;
}

let numbers = sum2(10,20)
