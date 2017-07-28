package bablomet

import grails.test.mixin.TestFor
import spock.lang.Specification
import groovy.sql.Sql

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Prsn)
class PrsnSpec extends Specification {
    def "find Prsn by name and fam"() {
        setup:
        mockDomain(Prsn)
        when:
        Prsn prsn = new Prsn(name: name, fam: fam,
                secName: secName,
                gender: gender,
                email: email,
                tel: tel,
                pasTp: pasTp,
                pasSer: pasSer,
                pasNo: pasNo,
                pasDt: pasDt,
                pasPlGet: pasPlGet,
                pasAdr: pasAdr).save()
        println(prsn.tsEnd)

        then:
        Prsn.findByNameAndFam(name, fam) != null
        where:
        name = "Andrea"
        fam = "Sims"
        secName = "Rick Kiehn"
        gender = "F"
        email = "asims0@admin.ch"
        tel = "1-(808)194-0003"
        pasTp = "TG"
        pasSer = "5214"
        pasNo = "315552"
        pasDt = new java.sql.Date(1945, 9, 8)
        pasPlGet = "Honolulu"
        pasAdr = "30 Reinke Center"
    }

    def "name constraints"() {
        setup:
//        mockForConstraintsTests(Prsn)
        mockDomain(Prsn)
        when:
        def Prsn = new Prsn(name: "Andrea",
                fam: "Sims",
                secName: "Rick Kiehn",
                gender: "F",
                email: "asims0@admin.ch",
                tel: "1-(808)194-0003",
                pasTp: "TG",
                pasSer: "5214",
                pasNo: "315552",
                pasDt: new java.sql.Date(1945, 9, 8),
                pasPlGet: "Honolulu",
                pasAdr: "30 Reinke Center")
        //Assignment of possible NULL values must be done via property assignment because assignment via map and constructor now leads to NULL if String is ""
        //See http://grails.org/doc/latest/ref/Constraints/nullable.html for more details
        Prsn.name = name
        Prsn.validate()

        then:
        Prsn.hasErrors() == !valid

        where:

        name | valid
        "1".multiply(51) | false //Name must not have more than 20 characters
        "1".multiply(50) | true
        "" | false //Name must not be blank

    }

    def "fam constraints"() {
        setup:
//        mockForConstraintsTests(Prsn)
        mockDomain(Prsn)
        when:
        def Prsn = new Prsn(name: "Andrea",
                fam: "Sims",
                secName: "Rick Kiehn",
                gender: "F",
                email: "asims0@admin.ch",
                tel: "1-(808)194-0003",
                pasTp: "TG",
                pasSer: "5214",
                pasNo: "315552",
                pasDt: new java.sql.Date(1945, 9, 8),
                pasPlGet: "Honolulu",
                pasAdr: "30 Reinke Center")
        //Assignment of possible NULL values must be done via property assignment because assignment via map and constructor now leads to NULL if String is ""
        //See http://grails.org/doc/latest/ref/Constraints/nullable.html for more details

        Prsn.fam = fam
        def valid1 = Prsn.validate()
        println(fam)
        println(valid1)
        then:
        def valid2 = Prsn.hasErrors()
        println(valid2)
        valid2 == !valid

        where:
        fam | valid
        "1".multiply(51) | false
        "1".multiply(50) | true
        "" | false
    }
//    def sql = Sql.newInstance(grailsApplication.config.dataSource.url,
//            grailsApplication.config.dataSource.username,
//            grailsApplication.config.dataSource.password,
//            grailsApplication.config.dataSource.driverClassName)
//
//    def setup() {
//        String sqlString = PrsnSpec.getResourceAsStream("/db/MOCK_PRSN.sql").text
//        sql.execute(sqlString)
//    }
//
//    def cleanup() {
//        sql.execute("delete from Prsn")
//    }
//
//    def "get prsn 787"() {
////        prsn = Prsn.findBySecname("Roseanne Christiansen")
//        println(Prsn.list())
//        expect:
//            prsn?.secname.equals("Roseanne Christiansen");
//    }
}
