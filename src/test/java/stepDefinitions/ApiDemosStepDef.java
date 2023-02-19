package stepDefinitions;

import androidScreen.ApiDemosScreen;
import androidScreen.MainScreen;
import androidScreen.PrefenceDependenciesScreen;
import androidScreen.PreferenceScreen;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.Driver;

import java.net.MalformedURLException;

public class ApiDemosStepDef {
    MainScreen mainScreen = new MainScreen();
    ApiDemosScreen apiDemosScreen = new ApiDemosScreen();
    PreferenceScreen preferenceScreen = new PreferenceScreen();
    PrefenceDependenciesScreen prefenceDependenciesScreen = new PrefenceDependenciesScreen();

    public ApiDemosStepDef() throws MalformedURLException {
    }



    @Given("kullanici ana ekranda")
    public void kullanici_ana_ekranda() {

        Assert.assertTrue(mainScreen.isMAinscreenDisplayed());
    }

    @Given("kullanici API Demos butununa tikladi")
    public void kullanici_apı_demos_butununa_tikladi() {
        mainScreen.apiDemosButton.click();

    }

    @Then("kullanici API Demos ekraninda")
    public void kullanici_apı_demos_ekraninda() {
        Assert.assertTrue(apiDemosScreen.isApiDemosDisplayed());

    }

    @Then("kullanici Preference butununa tikladi")
    public void kullanici_preference_butununa_tikladi() {
        apiDemosScreen.preference.click();

    }

    @Then("kullanici Preference ekraninda")
    public void kullanici_preference_ekraninda() {
        Assert.assertTrue(preferenceScreen.isPrefenceDisplayed());

    }

    @Then("kullanici Preference dependencies tikladi")
    public void kullanici_preference_dependencies_tikladi() {

        preferenceScreen.preferenceDependencies.click();
    }

    @Then("kullanici WiFi check box secmis olacak")
    public void kullanici_wi_fi_check_box_secmis_olacak() {
        if (prefenceDependenciesScreen.checkBox.getAttribute("checked").equals("false")){
            prefenceDependenciesScreen.checkBox.click();
        }

    }

    @Then("kullanici WiFi Settings tikladi")
    public void kullanici_wi_fi_settings_tikladi() {
        prefenceDependenciesScreen.wifiSettings.click();

    }

    @Then("WiFi setting popup geldi")
    public void wi_fi_setting_popup_geldi() {
        Assert.assertTrue(prefenceDependenciesScreen.cancelButton.isDisplayed());

    }

    @Then("kullanici {string} yazdi")
    public void kullanici_yazdi(String text) {

        prefenceDependenciesScreen.textBox.sendKeys(text);
    }

    @Then("kullanci ok butonuna tikladi")
    public void kullanci_ok_butonuna_tikladi() {
        prefenceDependenciesScreen.okButton.click();

    }

    @Given("App yuklensin")
    public void appYuklensin() {
        Driver.getAppiumDriver();
    }
}
