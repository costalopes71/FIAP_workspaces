//
//  API.swift
//  Carros
//
//  Created by Usuário Convidado on 10/08/2018.
//  Copyright © 2018 FIAP. All rights reserved.
//

import Foundation


class API {
    
    static let path = "https://carangas.herokuapp.com/cars"
    // objeto que configura a sessao, com o .shared pego configuracoes default
    static let session = URLSession.shared
    
    // static cria um metodo estatico de classe que nao pode ser sobrescrito
    // um class func cria um metodo estatico que PODE ser sobrescrito
    class func loadCars(onComplete : @escaping ([Car]) -> Void) {
        
        guard let url = URL(string: path) else {
            print("URL invalida!")
            return
        }
        
        let dataTask = session.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print("Erro ao tentar recuperar os dados da API.", error!.localizedDescription)
            }
            
            // faco um cast para HTTPURLResponse pq a requisicao foi por http, e posso usar o statusCode pra saber o erro
            guard let response = response as? HTTPURLResponse else {
                print("O servidor não respondeu.")
                return
            }
            
            if response.statusCode != 200 {
                print("Servidor respondeu com o código de erro:", response.statusCode)
                return
            }
            
            guard let data = data else {
                print("O data veio nulo")
                return
            }
            
            do {
                let cars = try JSONDecoder().decode([Car].self, from: data)
                onComplete(cars)
            } catch {
                print("JSON invalido: ", error.localizedDescription)
            }
        }
        
        dataTask.resume()
        
    }
    
}
