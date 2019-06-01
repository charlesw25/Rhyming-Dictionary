def findRhymes(filename, word):
    RhymeDict = {}
    RhymeList = []

    word_sounds = []

    vowel1 = ""
    vowel2 = ""

    check1 = []
    check2 = []

    with open(filename, "r") as f:
        for line in f:
            RhymeDict[line.split()[0]] = line.split()[1:]
        #print(RhymeDict)

    #print(RhymeDict[word])

    if word in RhymeDict:
        count1 = 0
        word_sounds = RhymeDict[word]
        for i in word_sounds:
            if len(i) == 3:
                vowel1 = i[0:2]
                check1 = word_sounds[count1+1:]

            count1 += 1
            #print(i)
    else:
        return []

    for wordski in RhymeDict:
        count2 = 0
        for sounds in RhymeDict[wordski]:
            if len(sounds) == 3:
                vowel2 = sounds[0:2]
                check2 = RhymeDict[wordski][count2+1:]
            count2 += 1
        if check1 == check2 and vowel1 == vowel2:
            RhymeList.append(wordski)
    return RhymeList


def getSounds(filename, word):
    RhymeDict = {}

    with open(filename,"r") as f:
        for line in f:
            RhymeDict[line.split()[0]] = line.split()[1:]

        #print(RhymeDict)
    if word in RhymeDict:
        return RhymeDict[word]
    return []


#print(getSounds("C:\\Users\\woodc\\IdeaProjects\\RhymingDictionaryHW1\\data\\cmudict-0.7b.txt", ""))
#print(len(findRhymes("C:\\Users\\woodc\\IdeaProjects\\RhymingDictionaryHW1\\data\\cmudict-0.7b.txt","RAT")))
