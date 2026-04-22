package com.instagrow.app.data

import kotlin.random.Random

object LocalData {
    val categories = listOf("Fashion", "Gym", "Food", "Business", "Travel")
    val tones = listOf("Funny", "Professional", "Motivational", "Sales")
    val bioStyles = listOf("Premium", "Minimal", "Fun")

    private val captionData = mapOf(
        "Fashion" to mapOf(
            "Funny" to listOf(
                "Outfit louder than my alarm today 😎",
                "Serving looks and spilling coffee, daily routine.",
                "Wardrobe therapy is cheaper than real therapy."
            ),
            "Professional" to listOf(
                "Confidence starts with the right fit.",
                "Modern style built for bold decisions.",
                "Designed to elevate your everyday presence."
            ),
            "Motivational" to listOf(
                "Dress like the goal is already yours.",
                "Your style can open doors before you speak.",
                "Small upgrades create powerful impressions."
            ),
            "Sales" to listOf(
                "Fresh drop is live—tap to shop now.",
                "Limited stock, unlimited style. DM to order.",
                "Your next favorite look is one click away."
            )
        ),
        "Gym" to mapOf(
            "Funny" to listOf(
                "I workout because punching people is frowned upon.",
                "Sweat now, snacks later.",
                "Gym hair, don’t care. Gains first."
            ),
            "Professional" to listOf(
                "Consistency is the real performance booster.",
                "Train smart. Recover better. Repeat daily.",
                "Discipline turns routines into results."
            ),
            "Motivational" to listOf(
                "One more rep is where growth begins.",
                "Progress is slow until it suddenly isn’t.",
                "Show up for yourself every single day."
            ),
            "Sales" to listOf(
                "Join our challenge and transform in 30 days.",
                "Plans built for your goals. Enroll today.",
                "Spots open now—start your fitness journey."
            )
        ),
        "Food" to mapOf(
            "Funny" to listOf(
                "Diet starts tomorrow. Today we feast 🍕",
                "If loving food is wrong, I’m always right.",
                "Calories don’t count in good company."
            ),
            "Professional" to listOf(
                "Crafted flavors, served with intention.",
                "Every plate tells a story of quality.",
                "Simple ingredients, exceptional experience."
            ),
            "Motivational" to listOf(
                "Feed your body and your ambition.",
                "Great food powers great work.",
                "Celebrate small wins with meaningful meals."
            ),
            "Sales" to listOf(
                "Today’s special is here—order before it’s gone.",
                "Hungry? Tap now for quick delivery.",
                "Fresh, hot, and ready. Book your table today."
            )
        ),
        "Business" to mapOf(
            "Funny" to listOf(
                "CEO by day, overthinker by night.",
                "Building empires and forgetting lunch.",
                "My coffee has meetings too."
            ),
            "Professional" to listOf(
                "Focused strategy creates sustainable growth.",
                "Delivering value through smart execution.",
                "Turning insights into measurable outcomes."
            ),
            "Motivational" to listOf(
                "Start small, scale with purpose.",
                "Big goals need brave action.",
                "Consistency beats intensity in business."
            ),
            "Sales" to listOf(
                "Ready to grow? Let’s build your next milestone.",
                "DM us to unlock your custom business plan.",
                "Book your free consultation this week."
            )
        ),
        "Travel" to mapOf(
            "Funny" to listOf(
                "BRB, collecting stamps not stress.",
                "Passport full, bank account empty.",
                "Lost? No, just exploring aggressively."
            ),
            "Professional" to listOf(
                "Travel thoughtfully, experience deeply.",
                "Curated journeys for modern explorers.",
                "Discover destinations that inspire perspective."
            ),
            "Motivational" to listOf(
                "Go where your soul feels alive.",
                "New places, new mindset, new growth.",
                "Adventure begins when comfort ends."
            ),
            "Sales" to listOf(
                "Limited travel deals—book your escape now.",
                "Plan your dream getaway with us today.",
                "Seats filling fast. Reserve your trip now."
            )
        )
    )

    private val trending = listOf("#instagood", "#viral", "#trending", "#explorepage", "#reels")
    private val general = listOf("#photooftheday", "#love", "#follow", "#contentcreator", "#daily")
    private val india = listOf("#india", "#indiagram", "#madeinindia", "#india_ig", "#incredibleindia")

    private val nicheHashtags = mapOf(
        "fashion" to listOf("#streetstyle", "#ootd", "#fashiondaily", "#styleinspo", "#fashionblogger"),
        "gym" to listOf("#fitlife", "#workoutmotivation", "#gymflow", "#fitnessjourney", "#liftheavy"),
        "food" to listOf("#foodie", "#foodlover", "#foodstagram", "#eatlocal", "#chefmode"),
        "business" to listOf("#entrepreneurlife", "#startupindia", "#businessgrowth", "#marketingtips", "#founderlife"),
        "travel" to listOf("#wanderlust", "#travelgram", "#bucketlist", "#tripplanner", "#travelmore")
    )

    private val bioTemplates = mapOf(
        "Premium" to listOf(
            "%s | Crafted for excellence ✨",
            "%s brand helping you stand out daily.",
            "Premium %s experiences, always."
        ),
        "Minimal" to listOf(
            "%s. Simple. Effective.",
            "We do %s, and we do it well.",
            "%s made easy."
        ),
        "Fun" to listOf(
            "%s with extra sparkle 🚀",
            "Turning %s into something exciting!",
            "%s + fun = us 😄"
        )
    )

    private val bestTimes = mapOf(
        "Fashion" to listOf("9:00 AM", "1:00 PM", "7:00 PM"),
        "Gym" to listOf("6:00 AM", "12:00 PM", "8:00 PM"),
        "Food" to listOf("11:00 AM", "2:00 PM", "9:00 PM"),
        "Business" to listOf("8:00 AM", "12:30 PM", "6:30 PM"),
        "Travel" to listOf("10:00 AM", "3:00 PM", "8:00 PM")
    )

    fun generateCaptions(category: String, tone: String): List<String> {
        return captionData[category]?.get(tone)?.shuffled()?.take(3).orEmpty()
    }

    fun generateHashtags(keyword: String): List<String> {
        val normalized = keyword.trim().lowercase()
        val niche = nicheHashtags.entries.firstOrNull { normalized.contains(it.key) }?.value
            ?: listOf("#${normalized.ifBlank { "growth" }}tips", "#${normalized.ifBlank { "creator" }}ideas", "#${normalized.ifBlank { "content" }}goals", "#${normalized.ifBlank { "insta" }}community", "#${normalized.ifBlank { "social" }}boost")

        return (trending.shuffled().take(5) +
            niche.shuffled().take(5) +
            general.shuffled().take(5) +
            india.shuffled().take(5)).shuffled()
    }

    fun generateBios(businessType: String, style: String): List<String> {
        val templates = bioTemplates[style].orEmpty()
        return templates.shuffled().take(Random.nextInt(2, 4)).map { template ->
            template.format(businessType.ifBlank { "Your Business" })
        }
    }

    fun bestPostingTimes(category: String): List<String> =
        bestTimes[category] ?: listOf("9:00 AM", "1:00 PM", "7:00 PM")
}
