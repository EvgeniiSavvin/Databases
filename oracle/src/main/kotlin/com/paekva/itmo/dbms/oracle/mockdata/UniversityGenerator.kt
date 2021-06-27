package com.paekva.itmo.dbms.oracle.mockdata

object UniversityGenerator {
    val disciplineNames = listOf(
        "Методология программного обеспечения", "Технологии веб-сервисов", "Системное и прикладное ПО", "Иностранный язык", "Цифровая культура"
    )

    val studyFormNames = listOf(
        "очная",
        "заочная"
    )

    val facultyNames = listOf(
        "ФПИиКТ",
        "СУиР",
        "БИТ",
        "ИТиП",
        "ИКТ"
    )

    val specialityNames = listOf(
        "66.66.66 - Несуществующаяя Информатика и вычислительная техника",
        "66.66.66 - Несуществующие Информационные системы и технологии",
        "09.03.01 - Информатика и вычислительная техника",
        "09.03.02 - Информационные системы и технологии",
        "09.03.03 - Прикладная информатика",
        "09.03.04 - Программная инженерия",
        "10.03.01 - Информационная безопасность",
        "11.03.01 - Радиотехника",
        "11.03.02 - Инфокоммуникационные технологии и системы связи",
        "11.03.03 - Конструирование и технология электронных средств",
        "11.03.04 - Электроника и наноэлектроника",
        "12.03.01 - Приборостроение",
        "12.03.02 - Оптотехника",
        "12.03.03 - Фотоника и оптоинформатика",
        "12.03.04 - Биотехнические системы и технологии",
        "12.03.05 - Лазерная техника и лазерные технологии",
        "13.03.01 - Теплоэнергетика и теплотехника",
        "13.03.02 - Электроэнергетика и электротехника",
        "13.03.03 - Энергетическое машиностроение",
        "14.03.01 - Ядерная энергетика и теплофизика",
        "14.03.02 - Ядерные физика и технологии",
        "15.03.01 - Машиностроение",
        "15.03.02 - Технологические машины и оборудование",
        "15.03.03 - Прикладная механика",
        "15.03.04 - Автоматизация технологических процессов и производств",
        "15.03.05 - Конструкторско-технологическое обеспечение машиностроительных производств",
        "15.03.06 - Мехатроника и робототехника",
        "16.03.01 - Техническая физика",
        "16.03.02 - Высокотехнологические плазменные и энергетические установки",
        "16.03.03 - Холодильная, криогенная техника и системы жизнеобеспечения"
    )

    val positionNames = listOf(
        "студент бакалавриата", "студент магистратуры", "студент аспирантуры", "доцент"
    )

    val groupNames = listOf(
        "P3119",
        "P3219",
        "P3319",
        "P3419",
        "P4116",
        "P41142"
    )

    val marks = listOf(
        Pair("A", 95),
        Pair("B", 85),
        Pair("C", 75),
        Pair("D", 65)
    )

    val studyYear = listOf(
        "2016/2017",
        "2017/2018",
        "2019/2020",
        "2020/2021"
    )

    val schoolNames = listOf(
        "09.04.04 – Программная инженерия"
    )

    val qualificationNames = listOf(
        "бакалавр", "магистр", "кандидат наук"
    )

    val uniBuildings = listOf(
        "Кронверкский", "Ломоносова", "Чайковского"
    )
}