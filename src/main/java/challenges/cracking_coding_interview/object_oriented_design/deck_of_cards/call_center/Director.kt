package challenges.cracking_coding_interview.object_oriented_design.deck_of_cards.call_center

internal class Director(callHandler: CallHandler) : Employee(callHandler) {
    init {
        rank = Rank.Director
    }
}