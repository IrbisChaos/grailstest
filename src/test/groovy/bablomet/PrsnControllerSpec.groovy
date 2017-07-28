package bablomet

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Created by VErmilov on 13.02.2017.
 */



@TestFor(PrsnController)
@Mock(Prsn)
class PrsnControllerSpec extends Specification {

    def "create action"() {
        setup:
        controller.params.name = "Andrea"
        controller.params.fam = "Sims"
        controller.params.secName = "Rick Kiehn"
        controller.params.gender = "F"
        controller.params.email = "asims0@admin.ch"
        controller.params.tel = "1-(808)194-0003"
        controller.params.pasTp = "TG"
        controller.params.pasSer = "5214"
        controller.params.pasNo = "315552"
        controller.params.pasDt = new java.sql.Date(1945, 9, 8)
        controller.params.pasPlGet = "Honolulu"
        controller.params.pasAdr = "30 Reinke Center"

        when:
        def model = controller.create()

        then:
        model.prsnInstance != null
        model.prsnInstance.name == name
        model.prsnInstance.fam == fam
        model.prsnInstance.secName == secName
        model.prsnInstance.gender == gender
        model.prsnInstance.email == email
        model.prsnInstance.tel == tel
        model.prsnInstance.pasTp == pasTp
        model.prsnInstance.pasSer == pasSer
        model.prsnInstance.pasNo == pasNo
        model.prsnInstance.pasDt == pasDt
        model.prsnInstance.pasPlGet == pasPlGet
        model.prsnInstance.pasAdr == pasAdr

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

//    def "create List action"() {
//        setup:
//        Prsn prsn1 = new Prsn (name: "Andrea",
//                fam : "Sims",
//                secName : "Rick Kiehn",
//                gender : "F",
//                email : "asims0@admin.ch",
//                tel : "1-(808)194-0003",
//                pasTp : "TG",
//                pasSer : "5214",
//                pasNo : "315552",
//                pasDt : new java.sql.Date(1945, 9, 8),
//                pasPlGet : "Honolulu",
//                pasAdr : "30 Reinke Center")
//        Prsn prsn2 = new Prsn (name: "2Andrea",
//                fam : "2Sims",
//                secName : "2Rick Kiehn",
//                gender : "M",
//                email : "2asims0@admin.ch",
//                tel : "2-(808)194-0003",
//                pasTp : "TG",
//                pasSer : "5214",
//                pasNo : "315552",
//                pasDt : new java.sql.Date(1945, 9, 8),
//                pasPlGet : "Honolulu",
//                pasAdr : "30 Reinke Center")
//        controller.params = new ArrayList<>() {{add(prsn1);add(prsn2);}}
//
//        when:
//        def models = controller.createMany()
//
//        then:
//        models.prsnInstances != null
//        models.prsnInstances(0).name == name1
//        models.prsnInstances(1).name == name2
//
//        where:
//        name1 = "Andrea"
//        name2 = "2Andrea"
//    }

    def 'save action: valid prsn'() {
        setup:
        controller.params.name = "Andrea"
        controller.params.fam = "Sims"
        controller.params.secName = "Rick Kiehn"
        controller.params.gender = "F"
        controller.params.email = "asims0@admin.ch"
        controller.params.tel = "1-(808)194-0003"
        controller.params.pasTp = "TG"
        controller.params.pasSer = "5214"
        controller.params.pasNo = "315552"
        controller.params.pasDt = new java.sql.Date(1945, 9, 8)
        controller.params.pasPlGet = "Honolulu"
        controller.params.pasAdr = "30 Reinke Center"

        when:
        request.method = 'POST'
        controller.save()

        then:
        response.redirectUrl != null
        response.redirectUrl.endsWith "show/1"
        controller.flash.message != null
    }

    def 'save action: invalid prsn'() {
        setup:
        controller.params.name = name
        controller.params.fam = fam
        controller.params.secName = "Rick Kiehn"
        controller.params.gender = "F"
        controller.params.email = "asims0@admin.ch"
        controller.params.tel = "1-(808)194-0003"
        controller.params.pasTp = "TG"
        controller.params.pasSer = "5214"
        controller.params.pasNo = "315552"
        controller.params.pasDt = new java.sql.Date(1945, 9, 8)
        controller.params.pasPlGet = "Honolulu"
        controller.params.pasAdr = "30 Reinke Center"

        when:
        request.method = 'POST'
        controller.save()

        then:
        view != null
        view.endsWith "create"
        model.prsnInstance.name == name
        model.prsnInstance.fam == null

        where:
        name = "Andrea"
        fam = ""
    }

    def 'show action: existing prsn'() {
        setup:
        prsnInstance.save()
        controller.params.id = prsnInstance.id

        expect:
        controller.show()  == [prsnInstance: prsnInstance]

        where:
        prsnInstance = new Prsn(name : "Andrea",
                fam : "Sims",
                secName : "Rick Kiehn",
                gender : "F",
                email : "asims0@admin.ch",
                tel : "1-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")
    }

    def 'show action List: existing prsn'() {
        setup:
        controller.params.idList = new ArrayList<Long>()
        prsnInstance.save()
        controller.params.idList.add(prsnInstance.id)
        prsnInstance2.save()
        controller.params.idList.add(prsnInstance2.id)

        expect:
        println(controller.showList().values())
        controller.showList()  == [prsnInstances: prsnInstances]
//        list(zip(*controller.showList())[4]) == new ArrayList<String>(){{add(prsnInstance.name);add(prsnInstance2.name);}}
//        >>> input = [(1, u'abc'), (2, u'def')]
//        >>> unzipped = zip(*input)
//        >>> print unzipped
//        [(1, 2), (u'abc', u'def')]
//        >>> print list(unzipped[0])
//        [1, 2]
        where:
        prsnInstance = new Prsn(name : "Andrea",
                fam : "Sims",
                secName : "Rick Kiehn",
                gender : "F",
                email : "asims0@admin.ch",
                tel : "1-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")
        prsnInstance2 = new Prsn(name : "2Andrea",
                fam : "2Sims",
                secName : "2Rick Kiehn",
                gender : "M",
                email : "2asims0@admin.ch",
                tel : "2-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")
        prsnInstances = new ArrayList<Prsn>() << prsnInstance << prsnInstance2
    }

    def 'show action: not existing prsn'() {
        setup:
        controller.params.id = 1L

        when:
        controller.show()

        then:
        response.redirectUrl != null
        response.redirectUrl.endsWith"list"
        controller.flash.message != null
    }

    def 'update action: valid prsn'() {
        setup:
        prsnInstance.save()
        controller.params.name = "John changed"
        controller.params.fam = "Doe changed"
        controller.params.version = prsnInstance.version
        println(prsnInstance.version)
        controller.params.id = prsnInstance.id

        when:
        request.method = 'POST'
        controller.update()

        then:
        response.redirectUrl != null
        response.redirectUrl.endsWith "show/1"
        controller.flash.message != null

        where:
        prsnInstance = new Prsn(name : "Andrea",
                fam : "Sims",
                secName : "Rick Kiehn",
                gender : "F",
                email : "asims0@admin.ch",
                tel : "1-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")

    }

    def 'delete action: existing prsn'() {
        setup:
        prsnInstance.save()
        controller.params.id = prsnInstance.id

        when:
        request.method = 'POST'
        controller.delete()

        then:
        response.redirectUrl != null
        response.redirectUrl.endsWith"list"
        controller.flash.message != null

        where:
        prsnInstance = new Prsn(name : "Andrea",
                fam : "Sims",
                secName : "Rick Kiehn",
                gender : "F",
                email : "asims0@admin.ch",
                tel : "1-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")
    }

    def 'update action: optimistic locking'() {
        setup:
        prsnInstance = prsnInstance.save(flush: true)

        assert  prsnInstance.id

        when:
        controller.params.name = "John changed"
        controller.params.fam = "Doe changed"
        //Decrease version of edited object to enforce optimistic locking validation
        controller.params.version = prsnInstance.version -1
        controller.params.id = prsnInstance.id
        controller.update(flush: true)

        then:
        view.endsWith"edit"
        model.prsnInstance == prsnInstance
        model.prsnInstance.hasErrors()
        model.prsnInstance.errors.each {println(it)}
        where:
        prsnInstance = new Prsn(name : "Andrea",
                fam : "Sims",
                secName : "Rick Kiehn",
                gender : "F",
                email : "asims0@admin.ch",
                tel : "1-(808)194-0003",
                pasTp : "TG",
                pasSer : "5214",
                pasNo : "315552",
                pasDt : new java.sql.Date(1945, 9, 8),
                pasPlGet : "Honolulu",
                pasAdr : "30 Reinke Center")
    }

}
