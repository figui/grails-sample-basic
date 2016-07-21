package grails.sample

class PersonService {

    static transactional = true

    def create(Person p) {
        return p.save()
    }

    def get(int id) {
        return Person.get(id)
    }

    def update(int id, Person p) {
        def currentPerson = Person.get(id)
        if(currentPerson) {
            currentPerson.properties = p.properties
            def result = currentPerson.save()
            return result ? result.id : -1
        } else {
            return -1
        }
    }

    def delete(id) {
        def currentPerson = Person.get(id)
        if(currentPerson) {
            currentPerson.delete()
            return true
        } else {
            return false
        }
    }
}
