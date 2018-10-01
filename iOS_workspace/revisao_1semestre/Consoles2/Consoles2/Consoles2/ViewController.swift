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
        lbManufacturer.text = "Fabricante \(console.manufacturer)"
        lbReleaseDate.text = "Data de lancamento: \(console.releaseDate)"
        lbUnitsSold.text = "Unidades vendidas: \(console.unitsSold)"
        ivConsole.image = UIImage(named: console.image)
    }


}

