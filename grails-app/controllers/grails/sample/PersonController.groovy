package grails.sample

class PersonController {

    def personService

    static allowedMethods = [create : 'POST', get : 'GET', update: 'PUT', delete : 'DELETE', getAll : 'GET']

    def create = {
        def p = new Person(request.JSON)
        render personService.create(p) ?: "{}"
    }

    def get = {
        render personService.get(params.id as int) ?: "{}"
    }

    def update = {
        def person = new Person()
        person.properties = request.JSON
        render personService.update(params.id as int, person) ?: "{}"
    }

    def delete = {
        render personService.delete(params.id) ?: "{}"
    }

    def getAll = {
        def result = ""
        Person.list().each {
            result += "${it.id} : ${it.name} ${it.lastName} <br/>"
        }
        render result ?: "[]"
    }
}
