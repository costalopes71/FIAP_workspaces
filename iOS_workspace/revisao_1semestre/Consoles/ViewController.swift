//
//  ViewController.swift
//  Consoles
//
//  Created by user140291 on 6/14/18.
//  Copyright © 2018 FIAP. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var console : Console!

    @IBOutlet weak var ivConsole: UIImageView!
    @IBOutlet weak var lbManufacturer: UILabel!
    @IBOutlet weak var lbReleaseDate: UILabel!
    @IBOutlet weak var lbUnitsSold: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        title = console.name
        lbManufacturer.text = "Fabricante: \(console.manufacturer)"
        lbReleaseDate.text = "Lancamento: \(console.releaseDate)"
        lbUnitsSold.text = "Unidades vendidas: \(console.unitsSold)"
        ivConsole.image = UIImage(named: console.image)
    }

}
