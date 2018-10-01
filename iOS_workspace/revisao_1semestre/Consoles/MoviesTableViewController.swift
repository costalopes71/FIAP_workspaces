//
//  MoviesTableViewController.swift
//  Consoles
//
//  Created by user140291 on 6/14/18.
//  Copyright © 2018 FIAP. All rights reserved.
//

import UIKit

class MoviesTableViewController: UITableViewController {

    var consoles : [Console] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //metodo que carrega o JSON
        loadConsoles()
    }

    //Este metodo ira abrir o arquivo JSON e converte-lo na nossa variavel array de consoles
    func loadConsoles() {
        
        //recuperando a url do arquivo JSON
        let url = Bundle.main.url(forResource: "consoles", withExtension: "json")!
        
        do {
            //Criando o data, a representacao binaria do arquivo. (Tipo um InputStream)
            let data = try Data(contentsOf: url)
            //decodificando o JSON em um array de Console
            consoles = try JSONDecoder().decode([Console].self, from: data)
            
            //Varremos o array para imprimir na area de Debug o nome e fabricante de cada console
            for console in consoles {
                print("Nome: \(console.name), Fabricante: \(console.manufacturer)")
            }
            
        } catch {
            print(error.localizedDescription)
        }
        
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // Retornando o numero de secoes da tabela
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // Retornando o numero de linhas da tabela, que sera baseado no numero de itens do nosso array
        return consoles.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //Recuperando uma celula baseada no identifcador cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)

        // Recuperando o console relativo aquela celula
        let console = consoles[indexPath.row]
        
        // Definindo os labels
        cell.textLabel?.text = console.name
        cell.detailTextLabel?.text = console.manufacturer

        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Recuperando a tela que ira aparecer
        let vc = segue.destination as! ViewController
        
        // O metodo indexPathForSelectedRow devolve o IndexPath da celula que foi selecionada. Com isso, podemos recuperar sua row, que nada mais eh que o indice da ceula. Usamos este indice para obter o console do array
        vc.console = consoles[tableView.indexPathForSelectedRow!.row]
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
