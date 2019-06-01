import unittest
from rhymes import RhymingDictionary


class TestGetSounds(unittest.TestCase):

    def setUp(self):
        pass

    def test_1(self):
        self.assertEqual(RhymingDictionary.getSounds("data/cmudict-0.7b", "CAR"), ['K', 'AA1', 'R'])

    def test_Shipping2(self):
        self.assertEqual(RhymingDictionary.getSounds("data/cmudict-0.7b", "FAR"), ['F', 'AA1', 'R'])

    def test_Shipping3(self):
        self.assertEqual(RhymingDictionary.getSounds("data/cmudict-0.7b", ""), [])


if __name__ == '__main__':
    unittest.main()
