//
//  BookViewController.swift
//  Bookstore
//
//  Created by Usuário Convidado on 26/10/2018.
//  Copyright © 2018 FIAP. All rights reserved.
//

import UIKit
import Firebase
import FirebaseFirestore


class BookViewController: UIViewController {

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
    
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfAuthor: UITextField!
    @IBOutlet weak var btAddEdit: UIButton!
    
    var book : LivroItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if book != nil {
            tfName.text = book.name
            tfAuthor.text = book.author
            btAddEdit.setTitle("Editar Livro", for: .normal)
        }
        
    }

    @IBAction func addEditBook(_ sender: UIButton) {
        
        let data : [String : String] = [
            "name" : tfName.text!,
            "author" : tfAuthor.text!
        ]
        
        if book == nil {
            
            firestore.collection(nacListCollection).addDocument(data: data) { (error) in
                if error != nil {
                    print(error!.localizedDescription)
                } else {
                    print("Item cadastrado com sucesso!")
                }
            }
            
        } else {
            firestore.collection(nacListCollection).document(book.id).updateData(data)
            
        }
        
        navigationController?.popToRootViewController(animated: true)
        
    }
    

}
