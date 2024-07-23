package com.kotdev.trading.core

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf

object Settings {

    val faqs = persistentListOf(
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_one,
            description = com.kotdev.trading.core_ui.R.string.faq_one_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_two,
            description = com.kotdev.trading.core_ui.R.string.faq_two_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_three,
            description = com.kotdev.trading.core_ui.R.string.faq_three_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_four,
            description = com.kotdev.trading.core_ui.R.string.faq_four_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_five,
            description = com.kotdev.trading.core_ui.R.string.faq_five_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_six,
            description = com.kotdev.trading.core_ui.R.string.faq_six_desc
        ),
        FaqItem(
            title = com.kotdev.trading.core_ui.R.string.faq_seven,
            description = com.kotdev.trading.core_ui.R.string.faq_seven_desc
        )
    )

    val articles = persistentListOf(
        Articles(
            com.kotdev.trading.core_ui.R.string.faq,
            null,
            com.kotdev.trading.core_ui.R.drawable.faq_background,
            color = Color(0xFF2B4E48),
            persistentListOf()
        ),
        Articles(
            com.kotdev.trading.core_ui.R.string.how_to_play_market,
            null,
            com.kotdev.trading.core_ui.R.drawable.how_to_play_background,
            color = Color(0xFF116D5D),
            persistentListOf(
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.how_to_play_title_one,
                    com.kotdev.trading.core_ui.R.string.how_to_play_description_one,
                    com.kotdev.trading.core_ui.R.drawable.how_to_play_background_one
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.how_to_play_title_two,
                    com.kotdev.trading.core_ui.R.string.how_to_play_description_two,
                    com.kotdev.trading.core_ui.R.drawable.how_to_play_background_two
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.how_to_play_title_three,
                    com.kotdev.trading.core_ui.R.string.how_to_play_description_three,
                    com.kotdev.trading.core_ui.R.drawable.how_to_play_background_three
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.how_to_play_title_four,
                    com.kotdev.trading.core_ui.R.string.how_to_play_description_four,
                    com.kotdev.trading.core_ui.R.drawable.how_to_play_background_four
                )
            )
        ),
        Articles(
            com.kotdev.trading.core_ui.R.string.why_invest,
            com.kotdev.trading.core_ui.R.string.why_invest_desc,
            com.kotdev.trading.core_ui.R.drawable.why_invest_background,
            color = Color(0xFF49C5B0),
            persistentListOf(
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.why_invest_title_one,
                    com.kotdev.trading.core_ui.R.string.why_invest_description_one,
                    com.kotdev.trading.core_ui.R.drawable.why_invest_background_one
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.why_invest_title_two,
                    com.kotdev.trading.core_ui.R.string.why_invest_description_two,
                    com.kotdev.trading.core_ui.R.drawable.why_invest_background_two
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.why_invest_title_three,
                    com.kotdev.trading.core_ui.R.string.why_invest_description_three,
                    com.kotdev.trading.core_ui.R.drawable.why_invest_background_three
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.why_invest_title_four,
                    com.kotdev.trading.core_ui.R.string.why_invest_description_four,
                    com.kotdev.trading.core_ui.R.drawable.why_invest_background_four
                )
            )
        ),
        Articles(
            com.kotdev.trading.core_ui.R.string.trade_fail,
            com.kotdev.trading.core_ui.R.string.trade_fail_desc,
            com.kotdev.trading.core_ui.R.drawable.trade_fail_background,
            color = Color(0xFF116D5D),
            persistentListOf(
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.trade_fail_title_one,
                    com.kotdev.trading.core_ui.R.string.trade_fail_description_one,
                    com.kotdev.trading.core_ui.R.drawable.trade_fail_background_one
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.trade_fail_title_two,
                    com.kotdev.trading.core_ui.R.string.trade_fail_description_two,
                    com.kotdev.trading.core_ui.R.drawable.trade_fail_background_two
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.trade_fail_title_three,
                    com.kotdev.trading.core_ui.R.string.trade_fail_description_three,
                    com.kotdev.trading.core_ui.R.drawable.trade_fail_background_three
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.trade_fail_title_four,
                    com.kotdev.trading.core_ui.R.string.trade_fail_description_four,
                    com.kotdev.trading.core_ui.R.drawable.trade_fail_background_four
                )
            )
        ),
        Articles(
            com.kotdev.trading.core_ui.R.string.investment,
            com.kotdev.trading.core_ui.R.string.investment_desc,
            com.kotdev.trading.core_ui.R.drawable.investment_background,
            color = Color(0xFF2B4E48),
            persistentListOf(
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.investment_title_one,
                    com.kotdev.trading.core_ui.R.string.investment_description_one,
                    com.kotdev.trading.core_ui.R.drawable.investment_background_one
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.investment_title_two,
                    com.kotdev.trading.core_ui.R.string.investment_description_two,
                    com.kotdev.trading.core_ui.R.drawable.investment_background_two
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.investment_title_three,
                    com.kotdev.trading.core_ui.R.string.investment_description_three,
                    com.kotdev.trading.core_ui.R.drawable.investment_background_three
                ),
                ArticleDetail(
                    com.kotdev.trading.core_ui.R.string.investment_title_four,
                    com.kotdev.trading.core_ui.R.string.investment_description_four,
                    com.kotdev.trading.core_ui.R.drawable.investment_background_four
                )
            )
        )
    )
}