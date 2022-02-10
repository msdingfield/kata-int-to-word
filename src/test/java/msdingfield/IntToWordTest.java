package msdingfield;

import org.junit.jupiter.api.Test;

import static msdingfield.IntToWord.toWord;
import static org.assertj.core.api.Assertions.assertThat;

class IntToWordTest {

    @Test
    void testSingleDigits() {
        assertThat(toWord(0)).isEqualTo("zero");
        assertThat(toWord(1)).isEqualTo("one");
        assertThat(toWord(2)).isEqualTo("two");
        assertThat(toWord(3)).isEqualTo("three");
        assertThat(toWord(4)).isEqualTo("four");
        assertThat(toWord(5)).isEqualTo("five");
        assertThat(toWord(6)).isEqualTo("six");
        assertThat(toWord(7)).isEqualTo("seven");
        assertThat(toWord(8)).isEqualTo("eight");
        assertThat(toWord(9)).isEqualTo("nine");
    }

    @Test
    void testTens() {
        assertThat(toWord(10)).isEqualTo("ten");
        assertThat(toWord(11)).isEqualTo("eleven");
        assertThat(toWord(12)).isEqualTo("twelve");
        assertThat(toWord(13)).isEqualTo("thirteen");
        assertThat(toWord(14)).isEqualTo("fourteen");
        assertThat(toWord(15)).isEqualTo("fifteen");
        assertThat(toWord(16)).isEqualTo("sixteen");
        assertThat(toWord(17)).isEqualTo("seventeen");
        assertThat(toWord(18)).isEqualTo("eighteen");
        assertThat(toWord(19)).isEqualTo("nineteen");

        assertThat(toWord(20)).isEqualTo("twenty");
        assertThat(toWord(21)).isEqualTo("twenty one");
        assertThat(toWord(22)).isEqualTo("twenty two");
        assertThat(toWord(23)).isEqualTo("twenty three");
        assertThat(toWord(24)).isEqualTo("twenty four");
        assertThat(toWord(25)).isEqualTo("twenty five");
        assertThat(toWord(26)).isEqualTo("twenty six");
        assertThat(toWord(27)).isEqualTo("twenty seven");
        assertThat(toWord(28)).isEqualTo("twenty eight");
        assertThat(toWord(29)).isEqualTo("twenty nine");

        assertThat(toWord(30)).isEqualTo("thirty");
        assertThat(toWord(31)).isEqualTo("thirty one");
        assertThat(toWord(40)).isEqualTo("forty");
        assertThat(toWord(41)).isEqualTo("forty one");
        assertThat(toWord(50)).isEqualTo("fifty");
        assertThat(toWord(51)).isEqualTo("fifty one");
        assertThat(toWord(60)).isEqualTo("sixty");
        assertThat(toWord(61)).isEqualTo("sixty one");
        assertThat(toWord(70)).isEqualTo("seventy");
        assertThat(toWord(71)).isEqualTo("seventy one");
        assertThat(toWord(80)).isEqualTo("eighty");
        assertThat(toWord(81)).isEqualTo("eighty one");
        assertThat(toWord(90)).isEqualTo("ninety");
        assertThat(toWord(91)).isEqualTo("ninety one");
    }

    @Test
    void testHundreds() {
        assertThat(toWord(100)).isEqualTo("one hundred");
        assertThat(toWord(101)).isEqualTo("one hundred one");
        assertThat(toWord(110)).isEqualTo("one hundred ten");
        assertThat(toWord(111)).isEqualTo("one hundred eleven");
        assertThat(toWord(121)).isEqualTo("one hundred twenty one");

        assertThat(toWord(200)).isEqualTo("two hundred");
        assertThat(toWord(201)).isEqualTo("two hundred one");
        assertThat(toWord(210)).isEqualTo("two hundred ten");
        assertThat(toWord(211)).isEqualTo("two hundred eleven");
        assertThat(toWord(221)).isEqualTo("two hundred twenty one");

        assertThat(toWord(900)).isEqualTo("nine hundred");
        assertThat(toWord(901)).isEqualTo("nine hundred one");
        assertThat(toWord(910)).isEqualTo("nine hundred ten");
        assertThat(toWord(911)).isEqualTo("nine hundred eleven");
        assertThat(toWord(921)).isEqualTo("nine hundred twenty one");
        assertThat(toWord(999)).isEqualTo("nine hundred ninety nine");
    }

    @Test
    void testThousands() {
        assertThat(toWord(1000)).isEqualTo("one thousand");
        assertThat(toWord(1001)).isEqualTo("one thousand one");
        assertThat(toWord(1100)).isEqualTo("one thousand one hundred");
        assertThat(toWord(1101)).isEqualTo("one thousand one hundred one");
        assertThat(toWord(9999)).isEqualTo("nine thousand nine hundred ninety nine");
        assertThat(toWord(10000)).isEqualTo("ten thousand");
        assertThat(toWord(15000)).isEqualTo("fifteen thousand");
        assertThat(toWord(19019)).isEqualTo("nineteen thousand nineteen");
        assertThat(toWord(99999)).isEqualTo("ninety nine thousand nine hundred ninety nine");
        assertThat(toWord(100000)).isEqualTo("one hundred thousand");
    }

    @Test
    void testMillions() {
        assertThat(toWord(1000000)).isEqualTo("one million");
        assertThat(toWord(1000001)).isEqualTo("one million one");
        assertThat(toWord(1516015)).isEqualTo("one million five hundred sixteen thousand fifteen");
        assertThat(toWord(15160150)).isEqualTo("fifteen million one hundred sixty thousand one hundred fifty");
        assertThat(toWord(151601500)).isEqualTo("one hundred fifty one million six hundred one thousand five hundred");
    }

    @Test
    void testBillions() {
        assertThat(toWord(1516015027)).isEqualTo("one billion five hundred sixteen million fifteen thousand twenty seven");
    }

    @Test
    void testNegatives() {
        assertThat(toWord(-1)).isEqualTo("negative one");
        assertThat(toWord(-91)).isEqualTo("negative ninety one");
        assertThat(toWord(-999)).isEqualTo("negative nine hundred ninety nine");
        assertThat(toWord(-100000)).isEqualTo("negative one hundred thousand");
        assertThat(toWord(-151601500)).isEqualTo("negative one hundred fifty one million six hundred one thousand five hundred");
        assertThat(toWord(-1516015027)).isEqualTo("negative one billion five hundred sixteen million fifteen thousand twenty seven");
    }

}
