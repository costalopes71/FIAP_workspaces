//
//  GamesTableViewController.swift
//  Consoles2
//
//  Created by user140291 on 6/15/18.
//  Copyright © 2018 FIAP. All rights reserved.
//

import UIKit

class GamesTableViewController: UITableViewController {

    var consoles : [Console] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadConsoles()
    }

    
    func loadConsoles() {
        
        // recuperar a url do JSON
        let url = Bundle.main.url(forResource: "consoles", withExtension: "json")!
        
        // criar o data, que eh a representacao binaria do arquivo
        do {
            //criando o Data
            let data = try Data(contentsOf: url)
            
            //decodificando o JSON em um array de Console
            consoles = try JSONDecoder().decode([Console].self, from: data)
            
        } catch {
            print(error.localizedDescription)
        }
        
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        // numero de secoes
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return consoles.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        // recuperando a celula
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        
        //recuperando o console relativo a celula
        let console = consoles[indexPath.row]
        
        // Configurando a celula
        cell.textLabel?.text = console.name
        cell.detailTextLabel?.text = console.manufacturer

        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let vc = segue.destination as! ViewController
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
