package bablomet
/**
 * Created by VErmilov on 13.02.2017.
 */
class AccController {
    def scaffold = Acc
//    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
//    static scaffold = Prsn
//
//    def index = {
//        def c = Prsn.createCriteria()
//        def people = c.list {
//            and{
//                order('fam','asc')
//                order('name','asc')
//            }
//        }
//        return [people: people]
//    }
//
//    def create = {
//        def prsnInstance = new Prsn()
//        prsnInstance.properties = params
//        return [prsnInstance: prsnInstance]
//    }
//
//    def save = {
//        def prsnInstance = new Prsn(params)
//        if (prsnInstance.save(flush: true)) {
//            flash.message = "${message(code: 'default.created.message', args: [message(code: 'prsn.name', default: 'Prsn'), prsnInstance.id])}"
//            redirect(action: "show", id: prsnInstance.id)
//        }
//        else {
//            render(view: "create", model: [prsnInstance: prsnInstance])
//        }
//    }
//
//    def show = {
//        def prsnInstance = Prsn.get(params.id)
//        if (!prsnInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            [prsnInstance: prsnInstance]
//        }
//    }
//
//    def showList = {
//        def prsnInstances = new ArrayList<Prsn>()
//        params.idList.each {def subj = Prsn.get(it); if (subj != null) {prsnInstances.add(subj)}}
//        if (!prsnInstances || prsnInstances.size() == 0) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.idList])}"
//            redirect(action: "list")
//        }
//        else {
//            [prsnInstances: prsnInstances]
//        }
//    }
//
//    def edit = {
//        def prsnInstance = Prsn.get(params.id)
//        if (!prsnInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            return [prsnInstance: prsnInstance]
//        }
//    }
//
//    def update = {
//        def prsnInstance = Prsn.get(params.id)
//        if (prsnInstance) {
//            println(params.version == null ? 'version is empty!' : params.version)
//            if (params.version) {
//                def version = params.version.toLong()
//                if (prsnInstance.version > version) {
//
//                    prsnInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'prsn.name', default: 'Prsn')] as Object[], "Another user has updated this Prsn while you were editing")
//                    render(view: "edit", model: [prsnInstance: prsnInstance])
//                    return
//                }
//            }
//            prsnInstance.properties = params
//            if (!prsnInstance.hasErrors() && prsnInstance.save(flush: true)) {
//                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'prsn.name', default: 'Prsn'), prsnInstance.id])}"
//                redirect(action: "show", id: prsnInstance.id)
//            }
//            else {
//                render(view: "edit", model: [prsnInstance: prsnInstance])
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//            redirect(action: "list")
//        }
//    }
//
//    def delete = {
//        def prsnInstance = Prsn.get(params.id)
//        if (prsnInstance) {
//            try {
//                prsnInstance.delete(flush: true)
//                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//                redirect(action: "list")
//            }
//            catch (org.springframework.dao.DataIntegrityViolationException e) {
//                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//                redirect(action: "show", id: params.id)
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'prsn.name', default: 'Prsn'), params.id])}"
//            redirect(action: "list")
//        }
//    }
//
//    def saveJsonToDomain(){s
//        String jsonObject = request.getJSON()                                                                      // get JSON data from request body
//        println "jsonObject : " + jsonObject
//        def jsonList = new JsonSlurper().parseText(jsonObject)
//        println "jsonList.size() : " + jsonList.size()
//        for(jsonObj in jsonList){
//            try{
//                Prsn prsn = new Prsn(jsonObj);
//                prsn.save(flush:true); // save JSON directly to grails domain
//                render prsn as JSON // render JSON object
//            }
//            catch(Exception e){
//                e.printStackTrace();
//                render "Error saving category : " + e;
//            }
//        }
//    }
}
