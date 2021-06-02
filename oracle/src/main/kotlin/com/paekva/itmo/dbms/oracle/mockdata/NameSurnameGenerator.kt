package com.paekva.itmo.dbms.oracle.mockdata

import java.time.Duration
import java.time.Instant

object NameSurnameGenerator {

    fun getRandomName(): String {
        val shouldBeFemale = randomBool()

        val name = if (shouldBeFemale) femaleNames[(0 until femaleNames.size).random()] else maleNames[(0 until maleNames.size).random()]

        val surname = if (shouldBeFemale) femaleSurnames[(0 until femaleSurnames.size).random()] else maleSurnames[(0 until maleSurnames.size).random()]

        val fathername = if (shouldBeFemale) femaleFatherNameAsMiddleName[(0 until femaleFatherNameAsMiddleName.size).random()] else maleFatherNameAsMiddleName[(0 until maleFatherNameAsMiddleName.size).random()]

        return "$surname $name $fathername"
    }

    fun generateRandomBirthDate() =
        Instant.now().minusMillis(Duration.ofHours(20 * 365 * 24).toMillis())

    fun studentIdByName(s: String) = "s${s.hashCode()}"

    val birthPlaces = listOf(
        "Москва",
        "Санкт-Петербург",
        "Новосибирск",
        "Владивосток",
        "Калининград",
        "Норильск"
    )

    private val maleNames = listOf(
        "Александр",
        "Алексей",
        "Борис",
        "Виктор",
        "Владимир",
        "Григорий",
        "Дмитрий",
        "Денис",
        "Евгений",
        "Игорь",
        "Константин",
        "Кирилл",
        "Никита",
        "Леонид",
        "Роман",
        "Сергей",
        "Максим",
        "Тимофей",
        "Иван",
        "Яков",
        "Петр",
        "Олег",
        "Николай",
        "Михаил",
        "Матвей",
        "Лев",
        "Артур",
        "Геннадий",
        "Георгий",
        "Аркадий",
        "Артем",
        "Вадим",
        "Богдан",
        "Руслан"
    )

    private val femaleNames = listOf(
        "Александра",
        "Алена",
        "Анна",
        "Анастасия",
        "Валерия",
        "Вера",
        "Виктория",
        "Вероника",
        "Дарья",
        "Евгения",
        "Екатерина",
        "Елизавета",
        "Инна",
        "Ирина",
        "Кира",
        "Кристина",
        "Ксения",
        "Лариса",
        "Лидия",
        "Любовь",
        "Майя",
        "Маргарита",
        "Марина",
        "Мария",
        "Недежда",
        "Олеся",
        "Ольга",
        "София",
        "Татьяна",
        "Ульяна"
    )

    private val maleSurnames = listOf(
        "Смирнов",
        "Иванов",
        "Кузнецов",
        "Соколов",
        "Попов",
        "Лебедев",
        "Козлов",
        "Новиков",
        "Морозов",
        "Петров",
        "Волков",
        "Соловьёв",
        "Васильев",
        "Зайцев",
        "Павлов",
        "Семёнов",
        "Голубев",
        "Виноградов",
        "Богданов",
        "Воробьёв",
        "Фёдоров",
        "Михайлов",
        "Беляев",
        "Тарасов",
        "Белов",
        "Комаров",
        "Орлов",
        "Киселёв",
        "Макаров",
        "Андреев"
    )

    private val fatherNameAsMiddleName = listOf(
        "Александров",
        "Алексеев",
        "Анатольев",
        "Андреев",
        "Антонов",
        "Васильев",
        "Викторов",
        "Витальев",
        "Владимиров",
        "Всеволодов",
        "Иванов",
        "Игорев",
        "Борисов",
        "Семенов",
        "Сергеев",
        "Станиславов",
        "Евгеньев",
        "Егоров",
        "Макаров",
        "Максимов",
        "Марков",
        "Матвеев",
        "Леонидов",
        "Львов",
        "Павлов",
        "Петров",
        "Гаврилов",
        "Геннадиев",
        "Георгиев",
        "Олегов"
    )

    private val femaleSurnames = maleSurnames.map { "${it}а" }
    private val maleFatherNameAsMiddleName = fatherNameAsMiddleName.map { "${it}ич" }
    private val femaleFatherNameAsMiddleName = fatherNameAsMiddleName.map { "${it}на" }
}