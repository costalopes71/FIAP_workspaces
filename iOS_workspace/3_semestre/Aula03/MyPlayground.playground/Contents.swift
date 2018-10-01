import Foundation

//Operadores
// +, -, *, /, =, %, !, >, <, >=, <=, &&, ||


//-----------------------------
//COLEÇOES
//-----------------------------

//-----------------------------
// ----> Array
//-----------------------------

//Array: Colecao ordenada de elementos de MESMO TIPO
//arrays em Swift não tem tamanho predeterminado, podem aumentar com o tempo. Posso determinar um tamanho mas ele nao fica fixo, posso adicionar elementos e ele aumentara.
var invites: [String] = [
    "Jaqueline",
    "Paula",
    "Thiago",
    "Camila",
    "Raquel"
];

//Adicionar um elemento ao array
invites.append("Carol");

//Remover item do array
invites.remove(at: 1);

//Descobrir indice de um elemento (indexOf)
//var index = invites.index(of: "Camila"); //o metodo index of retorna um optional
//invites.remove(at: index!); //jeito porco de desembrulhar um OPTIONAL

//metodo correto de desembrulhar um optional
if let index = invites.index(of: "Camila") {
    invites.remove(at: index)
}

//metodo contains
invites.contains("Camila");

//pegar item de um array
invites[3];


//-----------------------------
// ----> Dictionarys
//-----------------------------

var states = [
    "SP": "São Paulo",
    "MG": "Minas Gerais",
    "PA": "Pará"
];

//dicionarios retornam sempre um OPTIONAL
if let state = states["PA"] {
    print(state)
} else {
    print("Estado não cadastrado.");
};

// se eu puser underline no lugar do nome da variavel, ela eh uma variavel anonima
let _ = "Joao";

//adicionar um elemento dentro de um dicionario
states["RJ"] = "Rio de Janeiro";

//remover um valor do dicionario
states["RJ"] = nil;

//para saber o tamanho da coleçao (serve para todas colecoes, inclusive uma String é uma coleção):
states.count;
invites.count;
"Joao Carlos Costa Lopes".count;

//LOOPS (for in, while e repeat while)

//para cada convidado da colecao de convidados
for convidado in invites {
    print("\(convidado) foi convidado para a festa.")
}

//quando itero em um dicionario a variavel criada eh uma TUPLA com tipos nomeados e posso acessar a chave e o valor
for state in states {
    print("A sigla \(state.key) representa o estado \(state.value)");
}

//posso jogar valores de tupla em variaveis
let address: (street: String, number: Int, zipCode: String) = ("Av. Paulista", 1200, "03127-060");
var rua = address.street;

//Decompor uma tupla
var (rua2, numero, cep) = address;
//se eu nao quiser um dos valores basta colocar _
var (_, _, cepNovo) = address;

//Posso decompor no for tbm
for (sigla, estado) in states {
    print("A sigla: \(sigla) e o etado \(estado)");
}

//Range e Half Open Range
//para criar iterator
0...10 //crio um range de 0 ate 10, ou seja, o range considera até o ultimo numero
0..<10 //aqui criei um half open range, ou seja, estou desconsiderando o ultimo numero do range, ou seja a colecao criada sera de 0 a 9

for i in 0..<invites.count {
    print("O convidado \(i+1) é \(invites[i])");
}

var j = 0;

while j < invites.count {
    print("O convidado \(j+1) é \(invites[j])");
    j += 1
}

//CRIAR SEUS PROPRIOS OPERADORES

//Criar operador unario
prefix operator >-
prefix func >- (rhs: Int) -> Int {
    return rhs * rhs;
}

print(>-4)

postfix operator -<
postfix func -< (lhs: Int) -> Int {
    return lhs*lhs*lhs;
}

print(2-<)

//Criar operadores binarios
infix operator >-<
func >-< (lhs: Int, rhs: Int) -> String {
    return "\(lhs)\(rhs)"
}

print(20>-<18)


//Gerar um numero aleatorio
Int(arc4random_uniform(UInt32(60))+1) //dentro dos parenteses eh ate qual numero quero gerer, este numero e o seu retorno sao do tipo UInt32
