import Foundation

//FUNCOES

func sum(a: Int, b: Int) -> Int {
    return a + b;
}

func divide(a: Int, b: Int) -> Int {
    return a / b;
}

func multiply(a: Int, b: Int) -> Int {
    return a * b;
}

func subtract(a: Int, b: Int) -> Int {
    return a - b;
}

//criando uma funcao que retorna outra funcao
func getOperation(named operation: String) -> (Int, Int) -> Int {
    switch operation {
    case "soma":
        return sum
    case "subtracao":
        return subtract
    case "multiplicacao":
        return multiply
    default:
        return divide
    }
}

//estou pondo uma funcao dentro de uma variavel
var operation = getOperation(named: "soma")

//estou usando muinha variavel que possui dentro dela o metodo soma
operation(20, 5)

//Usando funcoes como parametros de funcoes
func applyOperation(_ a: Int,_ b: Int, operation: (Int, Int) -> Int ) -> Int {
    return operation(a, b)
}

let result = applyOperation(20, 6, operation: sum)
print(result)

//criando alias para funcao
typealias Operation = (Int, Int) -> Int

func applyOperation2(a: Int, b: Int, operation: Operation) -> Int {
    return operation(a, b)
}

//sintaxe de uma funcao
/*
 func nome(para: Tipo, param2: Tipo) -> TipoRetorno {
 //codigo
 return TipoRetorno
 }
*/

//Sintaxe de uma closure
/*
 {(para: Tipo, param2: Tipo) -> TipoRetorno in
    //codigo
    return TipoRetorno
 }
 */

//exemplo de clousere
let resultado2 = applyOperation(20, 3, operation: {(x: Int, y: Int) -> Int in
    return x % y
})
 

//simplificacao da escrita de uma clousere

let primeiraSimplificacao = applyOperation(20, 3, operation: {x, y -> Int in
    return x % y
})

let segundaSimplificacao = applyOperation(20, 3, operation: {x, y in
    return x % y
})

let terceiraSimplificacao = applyOperation(20, 3, operation: {
    return $0 % $1
})

let quartaSimplificacao = applyOperation(20, 3, operation: {$0 % $1})

//se a clousere for o ultimo parametro pode ser feita essa ultima simplificacao
let quintaSimplificacao = applyOperation(20, 3){$0 % $1}



