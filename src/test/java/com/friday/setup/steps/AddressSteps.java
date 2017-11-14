package com.friday.setup.steps;

import com.friday.core.Addressline;
import com.friday.services.Factory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


class AdressSteps {

    @Given("^The system is up and running$")
    public void system_running() throws Exception {
        System.out.println("Fill me later");
    }

    @When("^I pass address as \"([^\"]*)\"$")
    public void iPassAddressAs(String streetAddress) throws Exception {
        Factory factory = new Factory();
        String[] expectedAddress = Addressline.getAddressFields(streetAddress);
        factory.setAddressFormater(expectedAddress);
    }

    @Then("^I verify the address as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyTheAddressAsAnd(String street, String number) throws Exception {
        Factory factory = new Factory();
        assertEquals(factory.getAddressFormater()[0], street);
        assertEquals(factory.getAddressFormater()[1], number);
    }
}
