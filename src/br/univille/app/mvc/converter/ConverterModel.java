package br.univille.app.mvc.converter;

import br.univille.app.mvc.home.HomeView;

public class ConverterModel {

    private String typeFrom;
    private String typeTo;
    private String valueFrom;
    private String valueTo;

    HomeView homeView = new HomeView();

    public void setValueFrom(String valueFrom) {
        this.valueFrom = valueFrom;
    }

    public void setValueTo(String valueTo) {
        this.valueTo = valueTo;
    }

    public String getTypeFrom() {
        return typeFrom;
    }


    public void setTypeFrom(String typeFrom) {
        this.typeFrom = typeFrom;
    }

    public String getTypeTo() {
        return typeTo;
    }

    public void setTypeTo(String typeTo) {
        this.typeTo = typeTo;
    }

    public Double converter() throws ConverterException{
        Double result;
        switch (typeFrom){
            case "Kelvin":
                if ("Celsius".equals(typeTo)){
                    return (Double.valueOf(valueFrom) - 273.15);
                }
                else if ("Fahrenheit".equals(typeTo)){
                    return((Double.valueOf(valueFrom) - 273.15) * (9.0/5.0)) + 32;
                }
                else {
                    return Double.valueOf(valueFrom);
                }

            case "Celsius":
                if ("Fahrenheit".equals(typeTo)){
                    return ((Double.valueOf(valueFrom) * (9.0/5.0)) + 32);
                }
                else if ("Kelvin".equals(typeTo)){
                    return (Double.valueOf(valueFrom) + 273.15);
                }
                else {
                    return Double.valueOf(valueFrom);
                }

            case "Fahrenheit":
                if ("Celsius".equals(typeTo)){
                    return (Double.valueOf(valueFrom) - 32) * (5.0/9.0);
                }
                else if ("Kelvin".equals(typeTo)){
                    return ((Double.valueOf(valueFrom) - 32) * (5.0/9.0)) + 273.15;
                }
                else{
                    return Double.valueOf(valueFrom);
                }

        }
        return null;
    }


}
