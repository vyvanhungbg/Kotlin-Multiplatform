//
//  ItemTvShowTableViewCell.swift
//  iosApp
//
//  Created by Vy Hùng on 12/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import shared
import Foundation

class ItemTvShowTableViewCell: UITableViewCell {
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var imageVIew: UIImageView!
    @IBOutlet weak var startDate: UILabel!
    @IBOutlet weak var status: UILabel!
    @IBOutlet weak var content: UILabel!
    
    private let session: URLSession = URLSession(configuration: URLSessionConfiguration.default)
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        layer.cornerRadius = 12
    }
    
    func bindData(tvShow : TVShow){
                title.text = tvShow.name
                startDate.text = tvShow.startDate
                status.text = tvShow.status
        getImage(imageURL: tvShow.thumbnail, completion: {(data,error) in
            DispatchQueue.main.async { [unowned self] in
                // UI code
                self.imageVIew.image = UIImage(data: data!)
            }
        })
        
        // contentView.frame = contentView.frame.inset(by: UIEdgeInsets(top: 10, left: 10, bottom: 10, right: 10))
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
    func getImage(imageURL: String ,completion: @escaping (Data?, Error?) -> (Void)) {
        guard let url = URL(string: imageURL) else {
            return
        }
        
        let task = session.downloadTask(with: url,completionHandler: { (localUrl: URL?, response: URLResponse?, error: Error?) in
            if(localUrl != nil){
                do {
                    let data = try Data(contentsOf: localUrl!)
                    completion(data, nil)
                } catch let error {
                    completion(nil, error)
                }
            }
            
        })
        task.resume()
    }
    
}
