package grails.sample

class Person {

    int id
    String name
    String lastName

    static constraints = {
    }

    static mapping = {
        id column:'id', type:'integer'
    }

    @Override
    String toString() {
        return "${name} ${lastName}"
    }
}
