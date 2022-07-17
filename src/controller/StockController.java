package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Stock;

import controller.Service;
import view.StockFrame;

public class StockController {
	
	private Stock service = new Stock();

	public StockFrame iFrame;

	public void execute() {
		// TODO Frmae create edilmeli. listenerlar set edilmeli. frame setVisible(true)
		// yapılmalı.

		iFrame = new StockFrame();
		
		setListeners();
		iFrame.showData(null);
		iFrame.frame.setVisible(true);
	}

	private void setListeners() {
		iFrame.getBtn_Save().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				kaydet();
			}

		});

		iFrame.getBtn_Update().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				güncelle();
			}

		});
		iFrame.getBtn_Delete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sil();
			}

		});

	}

	public void kaydet() {
		// fill model - > model e ui daki bilgiler set edilmelidir.
		iFrame.getModel().save(iFrame.getData());
		iFrame.SetData("","","","","","","","");
		iFrame.showData(null);
		
	}
	
	public void güncelle() {
		iFrame.getModel().update(iFrame.getData());
//		service.update();
		iFrame.SetData("","","","","","","","");
		iFrame.showData(null);
	}

	public void sil() {
		iFrame.getModel().delete(iFrame.getData());
//		service.delete(iFrame.getData());
		iFrame.SetData("","","","","","","","");
		iFrame.showData(null);
	}
	
		

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockController controller = new StockController();
					controller.execute();
			

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
