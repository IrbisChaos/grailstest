import authentication.AuthenticatedUser
import domain.Character
import domain.Creditor
import domain.Debtor

// Place your Spring DSL code here
beans = {
    userCur(AuthenticatedUser) {

    }

    debtor(Debtor) {
        sum = 10000
        timeLimit = 7
    }

    creditor(Creditor) {
        sum = 10000
    }

    actor(Character) {
    }
}
