package com.example.nasaapp;


interface Technology { // Interface for all class
    public String[] getList();
    public String getInfo(int i);
}

class VisibleImagery implements Technology{
    private String[] list;
    private String[] info;
    public VisibleImagery() {
        list = new String[3];
        list[0] = "None";
        list[1] = "Advanced Vidicon Camera System";
        list[2] = "Image Dissector Camera System";

        info = new String[3];

        info[0] = "";

        info[1] = "The Nimbus Advanced Vidicon Camera System Visible Imagery L1,"
                + "HDF5 (NmAVCS1H) data set consists of black-and-white "
                + "images captured by the Advanced Vidicon Camera Systems onboard the Nimbus 1 ";

        info[2] = "This data set (NmIDCS3G) consists of daily, global image "
                + "composites constructed from Nimbus 3 and Nimbus"
                + " 4 Image Dissector Camera System (IDCS) imagery for"
                + " the region between 60 N and 60 S";

    }

    @Override
    public String[] getList() {
        return this.list;
    }
    @Override
    public String getInfo(int i) {
        return info[i];
    }
}
class InfraredImaging implements Technology{
    private String[] list;
    private String[] info;

    public InfraredImaging() {
        list = new String[] {
                "None",
                "High Resolution Infrared Radiometer",
                "Medium Resolution Infrared Radiometer",
                "Temperature-Humidity Infrared Radiometer"};

        info = new String[4];
        info[0] = "";
        info[1] = "The Nimbus High Resolution Infrared Radiometer Digital\n "
                + "Swath Data L1, HDF data set (NmHRIR1H) consists of High \n"
                + "Resolution Infrared Radiometer (HRIR) brightness temperatures obtained\n"
                + "by the Nimbus 1, Nimbus 2, and Nimbus 3 satellites during 1964, 1966, and 1969";

        info[2] = "The Nimbus 3 Medium-Resolution Infrared Radiometer (MRIR) experiment\n"
                + " measured the intensity and distribution of the electromagnetic \n"
                + "radiation emitted by and reflected from the earth and\n"
                + " its atmosphere in five selected wavelength intervals\n"
                + " from 0.2 to 23 micrometers";

        info[3] = "This data set (NmTHIR115-3H) consists of daily, global\n"
                + " composites of radiative temperatures obtained in the 11.5 µm window (10.5 µm - 12.5 µm) by\n"
                + " the Temperature-Humidity Infrared Radiometer (THIR)\n"
                + " on board the Nimbus 4 satellite";

    }

    @Override
    public String[] getList() {
        return list;
    }

    @Override
    public String getInfo(int i) {
        return info[i];
    }
}
class MicrowaveImaging implements Technology{
    private String[] list;
    private String[] info;
    public MicrowaveImaging() {

        list = new String[] {"None", "Electronic Scanning Microwave Radiometer", "Scanning Multi spectral Microwave Radiometer"};

        info = new String[3];
        info[0] = "";
        info[1] = "An electronically scanning microwave radiometer system"
                + " has been designed, developed, and tested for measurement of meteorological,"
                + " geomorphological and oceanographic parameters from NASA/GSFC's Nimbus E satellite";

        info[2] = "The Scanning Multichannel Microwave Radiometer (SMMR) is a passive"
                + " microwave radiometer measuring dual polarized microwave radiation from"
                + " the earth's surface and atmosphere in"
                + " 5 frequencies; 6.63, 10.69, 18.0, 21.0 and 37.0 GHz. SMMR Swath width is 600 km.";
    }
    @Override
    public String[] getList() {
        return list;
    }
    @Override
    public String getInfo(int i) {
        return info[i];
    }
}
class Sounding implements Technology{
    private String[] list;
    private String[] info;
    public Sounding() {
        list = new String[] {
                "None",
                "High Resolution Infrared Sounder",
                "Infrared Interferometer Spectrometer",
                "Limb Infrared Monitor of the Stratosphere",
                "Limb Radiance Inversion Radiometer",
                "Nimbus E Microwave Spectrometer",
                "Pressure Modulated Radiometer",
                "Stratospheric and Mesospheric Sounder",
                "Scanning Microwave Spectrometer",
                "Selective Chopper Radiometer",
                "Satellite Infrared Spectrometer"};

        info = new String[11];
        info[0] = "";
        info[1] = "The High-resolution Infrared Radiation Sounder (HIRS/4)"
                + " provides calibrated vertical profiles of temperature"
                + " and humidity; information on cloud cover,"
                + " cloud top height, cloud top temperature and"
                + " cloud phase, as well as surface albedo.";
        info[2] = "(IRIS) "
                + "The IRIS actually acts as three separate instruments. First, it is a very sophisticated thermometer. It can determine the distribution of heat energy a body is emitting, allowing scientists to determine the temperature of that body or substance. Second, the IRIS is a device that can determine when certain types of elements or compounds are present in an atmosphere or on a surface. Third, it uses a separate radiometer to measure the total amount of sunlight reflected by a body at ultraviolet, visible, and infrared frequencies.";

        info[3] = "The Limb Infrared Monitor of the Stratosphere (LIMS) is a 6 channel scanning radiometer which measures the infrared emission by the earth's limb. These measurements are inverted to yield distributions of temperature, ozone, water vapor, nitric acid and nitrogen dioxide.";
        info[4] = "The limb radiance inversion radiometer (LRIR) and limb infrared monitor of the stratosphere (LIMS) experiments aboard the Nimbus 6 and 7 spacecraft have made observations of infrared emission by CO2, O3, H2O, HNO3, and NO2 at the earth's limb";
        info[5] = "The Nimbus 5 microwave spectrometer has been used to measure thermal radiation in five frequency bands between 22.235 and 58.8 gigahertz, and has yielded both the temperature profile and, over ocean, the vapor and liquid water content of the terrestrial atmosphere, even in overcast conditions";
        info[6] = "This article describes a pressure‐modulator instrument which is designed to measure trace constituents of the stratosphere from a balloon platform at an altitude of about 40 km. Double‐sided limb‐scanning allows profiling below the instrument and a direct determination of the instrument attitude from the radiance data.";
        info[7] = "The Improved Stratospheric and Mesospheric Sounder (ISAMS) Level 3AL data product consists of daily, 4 degree increment latitude-ordered vertical profiles of temperature and concentrations of O3, H2O, CH4, CO, N2O, N2O5, NO2, and aerosol absorption coefficients.";
        info[8] = "a microwave spectrometer with a novel technique of locking a frequency ‘‘scanning window’’ [F1,F3] in the radiation source to a microwave rotational absorption peak. The center (F2) of the scanning window is initially locked to the resonant frequency (Fr) of a tunable resonant cavity so that the center of the scanning window may be tuned by changing the resonant frequency of the cavity.";
        info[9] = "An improved version of the selective chopper radiometer which has successfully flown for three years on the Nimbus 4 satellite has been built for the Nimbus 5 satellite which was launched in December 1972. ";
        info[10] = "Spectrometers use lenses, mirrors, and other hardware to dissassemble light into its component wavelengths, similar to how raindrops spread the sun’s light into a rainbow. ";
    }
    @Override
    public String[] getList() {
        return list;
    }
    @Override
    public String getInfo(int i) {
        return info[i];
    }
}
class Others implements Technology{
    private String[] list;
    private String[] info;

    public Others() {
        list = new String[] {
                "None",
                "Backscatter Ultraviolet Spectrometer",
                "Costal Zone Color Scanner",
                "Earth Radiation Budget",
                "Stratospheric Aerosol Measurement-II",
                "Surface Composition Mapping Radiometer",
                "Solar Backscatter Ultraviolet",
                "Tropical Wind Energy Conversion"
        };

        info = new String[8];
        info[0] = "";
        info[1] = "The Solar Backscatter Ultraviolet Radiometer, or SBUV/2, is a series of operational remote sensors on NOAA weather satellites in Sun-synchronous orbits which have been providing global measurements of stratospheric total ozone, as well as ozone profiles, since March 1985";
        info[2] = "The coastal zone color scanner (CZCS) was a multi-channel scanning radiometer aboard the Nimbus 7 satellite, predominately designed for water remote sensing.";
        info[3] = "The Earth Radiation Budget (at the top of the atmosphere) describes the overall balance between the incoming energy from the sun and the outgoing thermal (longwave) and reflected (shortwave) energy from the earth. ";
        info[4] = "Tratospheric Aerosol Measurement 2 instrument mapped vertical profiles of small particles (aerosols) in the atmosphere over the Earth's polar regions. ";
        info[5] = "A three-channel scanning radiometer on ''Nimbus''-5 (launched December 1972) measuring radiation in the visible and infrared spectrum to determine the composition of the earth's surface.";
        info[6] = "The Solar Backscatter Ultraviolet Radiometer-2 (SBUV/2) is an operational remote sensor designed to map, on a global scale, total ozone concentrations and the vertical distribution of ozone in the earth's atmosphere. ";
        info[7] = "An observing system utilizing lightweight balloons to record weather data that were transmitted through ''Nimbus''-6, launched in June 1975, to a ground station.";
    }





    @Override
    public String[] getList() {
        return list;
    }





    @Override
    public String getInfo(int i) {
        return info[i];
    }
}
public class TechnologyHelper {
    public static void main(String []args) {
        Technology tech = new Others();
        System.out.println(tech.getInfo(3));
    }
}

