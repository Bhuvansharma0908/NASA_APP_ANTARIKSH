package com.example.nasaapp;


import java.io.Serializable;

interface Nimbus extends Serializable {

    public  String getName();
    public String getLaunchDate();
    public String getLaunchLocation();
    public String getDecayDate();
    public String getObjectives();
    public String getPartener();
    public String getLaunchVehicle();
    public String getHint();
}
class Nimbus_1 implements Nimbus{

    @Override
    public String getName() {
        return "Nimbus 1";
    }





    @Override
    public String getLaunchDate() {
        return "1964-08-28";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "1974-05-16";
    }


    @Override
    public String getObjectives() {
        return "It was designed to serve as a stabilized, "
                + "earth-oriented platform for the testing "
                + "of advanced meteorological sensor systems "
                + "and for collecting meteorological data";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space Science";
    }





    @Override
    public String getLaunchVehicle() {
        return "Thrust Augmented Thor-Agena B";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 1\n\n"

                +"-> It has Mass of 374.4 kg.\n\n"

                +"Visible Imagery:\n"
                +"Advanced Vidicon Camera System\n\n"

                +"Infrared Imaging:\n"
                +"High Resolution Infrared Radiometer\n";
    }
}





class Nimbus_2 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 2";
    }





    @Override
    public String getLaunchDate() {
        return "1966-05-15";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return " was designed to serve as a stabilized,"
                + " earth-oriented platform for the"
                + " testing of advanced meteorological"
                + " sensor systems and the collecting of meteorological data.";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space Science";
    }





    @Override
    public String getLaunchVehicle() {
        return "Thrust Augmented Thor-Agena D";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 2\n\n"

                +"-> It has Mass of 413.7 kg.\n\n"

                +"Visible Imagery:\n"
                +"Advanced Vidicon Camera System\n\n"

                +"Infrared Imaging:\n"
                +"High Resolution Infrared Radiometer\n"
                +"Medium Resolution Infrared Radiometer\n";
    }
}





class Nimbus_3 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 3";
    }





    @Override
    public String getLaunchDate() {
        return "1969-04-14";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return "It , was designed to serve as a stabilized, earth-oriented"
                + " platform for the testing of advanced meteorological"
                + " sensor systems and the collecting of meteorological data.";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space Science";
    }





    @Override
    public String getLaunchVehicle() {
        return "Thor-Agena";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 3\n\n"

                +"-> It has Mass of 575.6 kg.\n\n"

                +"Visible Imagery:\n"
                +"Image Dissector Camera System\n\n"

                +"Infrared Imaging:\n"
                +"High Resolution Infrared Radiometer\n"
                +"Medium Resolution Infrared Radiometer\n";
    }
}





class Nimbus_4 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 4";
    }





    @Override
    public String getLaunchDate() {
        return "1970-04-08";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return "It was designed to serve as a stabilized, earth-oriented"
                + "platform for the testing of advanced "
                + "meteorological sensor systems, and for"
                + " collecting meteorological data.";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space and Terrestrial";
    }





    @Override
    public String getLaunchVehicle() {
        return "Thor-Agena";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 4\n\n"

                +"-> It has Mass of 619.6 kg.\n\n"

                +"Visible Imagery:\n"
                +"Image Dissector Camera System\n\n"

                +"Infrared Imaging:\n"
                +"Temperature-Humidity Infrared Radiometer\n\n"

                +"Sounding:\n"
                +"Infrared Interferometer Spectrometer\n"
                +"Selective Chopper Radiometer\n"
                +"Satellite Infrared Spectrometer\n\n"

                +"Others:\n"
                +"Backscatter Ultraviolet Spectrometer\n";
    }
}





class Nimbus_5 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 5";
    }





    @Override
    public String getLaunchDate() {
        return "1972-12-11";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return "The Nimbus 5 research-and-development satellite was"
                + " designed to serve as a stabilized, earth-oriented"
                + " platform for the testing of advanced meteorological sensor systems and "
                + "collecting meteorological and geological data on a global scale.";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space and Terrestrial";
    }





    @Override
    public String getLaunchVehicle() {
        return " Delta";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 5\n\n"

                +"-> It has Mass of 619.6 kg.\n\n"

                +"Microwave Imaging:\n"
                +"Electronic Scanning Microwave Radiometer\n\n"

                +"Sounding:\n"
                +"Nimbus E Microwave Spectrometer\n"
                +"Selective Chopper Radiometer\n\n"

                +"Others:\n"
                +"Surface Composition Mapping Radiometer\n";
    }
}





class Nimbus_6 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 6";
    }





    @Override
    public String getLaunchDate() {
        return "1975-06-12";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return "The Nimbus 6 research-and-development satellite served as a "
                + "stabilized, earth-oriented platform for testing advanced "
                + "systems for sensing and collecting meteorological data on a global scale. ";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space";
    }





    @Override
    public String getLaunchVehicle() {
        return " Delta";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 6\n\n"

                +"-> It has Mass of  585 kg.\n\n"

                +"Microwave Imaging:\n"
                +"Electronic Scanning Microwave Radiometer\n\n"

                +"Sounding:\n"
                +"High Resolution Infrared Sounder\n"
                +"Limb Radiance Inversion Radiometer\n"
                +"Pressure Modulated Radiometer\n"
                +"Scanning Microwave Spectrometer\n\n"

                +"Others:\n"
                +"Earth Radiation Budget\n"
                +"Tropical Wind Energy Conversion and Reference Level Experiment\n";
    }
}





class Nimbus_7 implements Nimbus{





    @Override
    public String getName() {
        return "Nimbus 7";
    }





    @Override
    public String getLaunchDate() {
        return "1978-10-24";
    }





    @Override
    public String getLaunchLocation() {
        return "Vandenberg AFB, United States";
    }





    @Override
    public String getDecayDate() {
        return "Continue";
    }





    @Override
    public String getObjectives() {
        return "The Nimbus 7 research-and-development satellite served as a "
                + "stabilized, earth-oriented platform for the testing "
                + "of advanced systems for sensing and "
                + "collecting data in the pollution, oceanographic and "
                + "meteorological disciplines.";
    }





    @Override
    public String getPartener() {
        return "NASA-Office of Space";
    }





    @Override
    public String getLaunchVehicle() {
        return " Delta";
    }





    @Override
    public String getHint() {
        return ""
                +"Nimbus 7\n"
                +"-> It has Mass of 832 kg.\n\n"

                +"Infrared Imaging:\n"
                +"Temperature-Humidity Infrared Radiometer\n\n"

                +"Microwave Imaging:\n"
                +"Scanning Multispectral Microwave Radiometer\n\n"

                +"Sounding:\n"
                +"Limb Infrared Monitor of the Stratosphere\n"
                +"Stratospheric and Mesospheric Sounder\n\n"

                +"Others:\n"
                +"Costal Zone Color Scanner\n"
                +"Earth Radiation Budget\n"
                +"Stratospheric Aerosol Measurement-II\n"
                +"Solar Backscatter Ultraviolet/Total Ozone Mapping Spectrometer\n";
    }
}



