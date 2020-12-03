package br.univille.app.mvc.converter;

import br.univille.app.mvc.home.HomeView;

public class ConverterController {

    private HomeView view;
    private ConverterModel model;
    private String result;

    public ConverterController(HomeView view, ConverterModel model){
        this.view = view;
        this.model = model;
    }

    public void callConverter(){
        model.setTypeFrom(view.getComboBoxFrom());
        model.setTypeTo(view.getComboBoxTo());
        model.setValueFrom(view.getValueFrom());
        try {
            view.setResult(model.converter());
        }catch (ConverterException e) {
            e.getMessage();
        }
    }

}
