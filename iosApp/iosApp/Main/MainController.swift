//
//  MainController.swift
//  iosApp
//
//  Created by Vy Hùng on 12/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import shared

class MainController: UIViewController {

    private let dataSourceTVShow = InjectHelper().getTVShowRepository()
    
    @IBOutlet weak var tableViewMain: UITableView!
    
    private var tvShows = [TVShow]()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
       
        tableViewMain.delegate = self
        tableViewMain.dataSource = self
        tableViewMain.register(UINib(nibName: "ItemTvShowTableViewCell", bundle: nil), forCellReuseIdentifier: "TVShowCell")
        
        self.tableViewMain.contentInset = UIEdgeInsets(top: 12, left: 0, bottom: 0, right: 0)
        
        
        dataSourceTVShow.getAllTVShow(completionHandler: { (page: Page?,  error: Error?) in
            print("page")
          //  print(page)
           // print(error)
            if(page != nil){
                self.tvShows = page!.tv_shows
            }

            //self.tableViewMain.reloadData()
            DispatchQueue.main.async {
                // UI code
                self.tableViewMain.reloadData()
            }
        })
        
        
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension   MainController:UITableViewDelegate{
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("here")
    }
}
extension   MainController:UITableViewDataSource{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        print(tvShows.count)
        return tvShows.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "TVShowCell",for: indexPath) as! ItemTvShowTableViewCell
        
        cell.contentView.layoutMargins = .init(top: 12.0, left: 23.5, bottom: 0.0, right: 23.5)
        
        let tvShow = tvShows[indexPath.row]
        cell.bindData(tvShow: tvShow)
        print(tvShow)
        return cell
    }
}
