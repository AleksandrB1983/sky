import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void limitsOfSwitchingOnStations() {
        Radio radio = new Radio();

        radio.setCurrentStation(1);
        radio.setCurrentStation(8);
        radio.setCurrentStation(9);
        radio.setCurrentStation(0);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lessMinimumRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkingTheButtonIsNext() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        radio.next();

        int expected = 1;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void moreMaximumRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkingThePreviousButton() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        radio.prev();

        int expected = 8;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void directSwitchingByRadioStationNumber() {
        Radio radio = new Radio();
        radio.setCurrentStation(2);
        radio.setCurrentStation(7);
        radio.setCurrentStation(4);
        radio.setCurrentStation(9);
        radio.setCurrentStation(0);
        radio.setCurrentStation(5);

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void volumeSwitchingLimits() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.setCurrentVolume(1);
        radio.setCurrentVolume(99);
        radio.setCurrentVolume(100);

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lessMinimumVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void moreMaximumVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseTheVolumeWithTheButtonMore() {
        Radio radio = new Radio();
        radio.setCurrentVolume(98);
        radio.more();
        radio.more();
        radio.more();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseTheVolumeWithTheButtonLess() {
        Radio radio = new Radio();
        radio.setCurrentVolume(2);
        radio.less();
        radio.less();
        radio.less();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void maximumRadioStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkingTheButtonNext() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkingTheButtonPrev() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeInLimitValue() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.more();
        radio.more();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeReductionInLimitValue() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);
        radio.less();
        radio.less();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}
