//
//  TableViewController.swift
//  Bookstore
//
//  Created by Usuário Convidado on 26/10/2018.
//  Copyright © 2018 FIAP. All rights reserved.
//

import UIKit
import Firebase
import FirebaseFirestore

class TableViewController: UITableViewController {

    lazy var firestore : Firestore = {
        
        let settings = FirestoreSettings()
       settings.areTimestampsInSnapshotsEnabled = true
        settings.isPersistenceEnabled = true
        
        let firestore = Firestore.firestore()
        firestore.settings = settings
        return firestore
    }()
    
    var firestoreListener : ListenerRegistration!
    let nacListCollection = "rm78573rm77861rm79259"
    var bookList : [LivroItem] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadItems()
    }

    func loadItems() {
        
        firestoreListener = firestore.collection(nacListCollection).order(by: "name").addSnapshotListener(includeMetadataChanges: true, listener: { (snapshot, error) in
            
            if error != nil {
                print(error!.localizedDescription)
            } else {
                guard let snapshot = snapshot else {return}
                
                if snapshot.metadata.isFromCache || snapshot.documentChanges.count > 0 {
                    self.showItems(snapshot : snapshot)
                }
                
            }
            
        })
        
    }
    
    func showItems(snapshot : QuerySnapshot) {
        
        bookList.removeAll()
        for document in snapshot.documents {
            let data = document.data()
            let name = data["name"] as! String
            let author = data["author"] as! String
            let bookItem = LivroItem(name: name, author: author, id: document.documentID)
            self.bookList.append(bookItem)
        }
        tableView.reloadData()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        guard let _ = sender as? UITableViewCell else {return}
        guard let vc = segue.destination as? BookViewController else {return}
        let bookItem = bookList[tableView.indexPathForSelectedRow!.row]
        vc.book = bookItem
        
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return bookList.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)

        let bookItem = bookList[indexPath.row]
        cell.textLabel?.text = bookItem.name
        cell.detailTextLabel?.text = bookItem.author
        
        return cell
    }
    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            
            let bookItem = bookList[indexPath.row]
            firestore.collection(nacListCollection).document(bookItem.id).delete()
        }

    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let bookItem = bookList[indexPath.row]
        let data: [String: Any] = [
            "name": bookItem.name,
            "author": bookItem.author
        ]
        firestore.collection(nacListCollection).document(bookItem.id).updateData(data)
    }

}
