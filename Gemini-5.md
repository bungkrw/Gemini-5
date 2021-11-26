# Group: Jekcea
## Team Members
*   Ekaphat Seamthong 6188039
*   Alisa Uthikamporn 6188025
*   Jirachaya Wongsuppakarn 6188046
*   Kanrawee Chiamsakul 6188049
*   Warat Phat-in 6188035
## ITCS431 Software Design and Development (2020)
## Requirement Analysis of the Gemini System
### Functional requirements
1. The user must be able to log in to the system as well as config the operations.
2. The system must provide a telescope simulator used for planning observations.
3. The science observer can monitor the data acquisition and validate the data integrity.
4. The system must allow the telescope operator to check the integrity of the system by input specific format of command. 
5. For the maintenance and test operation level, the system must allow full access to all subsystems.
6. The system must support remote operations at a level which depends on the remote site’s capability.
7. The observing astronomer can devise a science plan including interactive observing for the collection of science data.
8. The observing astronomer can acquire astronomical data and assess data quality on-line.
9. The system must offer the observing astronomer the status information both automatically and on request at any required level.
10. The observing astronomer cannot send control commands for the telescope directly.
11. The observing astronomer can enquire about the status of the telescope or any subsystem at any time.
12. The observing astronomer can submit observing commands via the scheduler program.
13. Operations staff can enable direct interactive operation.
14. Operations staff can control the Gemini 8m Telescopes indirectly via a scheduler program or directly via commands.
15. Operations staff can change the operational status of units according to the results of tests performed on such units.
16. The system must allow operations staff to monitor general performance and system safety.
17. Operations staff can access all commands and maintenance procedures in case of problems including direct control of physical units.
18. Operations staff shall have access to operation tables in update mode, while observing astronomers will have access to them only in read mode.
19. The system must allow software development and maintenance staff to perform system generation and installation of new software packages or new releases, according to established test and validation procedures.
20. The system must have the capability of multi-point monitoring.
21. The operation supervisor can monitor all relevant data from the telescope and instrument, while some users are in control of the Gemini 8m Telescopes.
22. The visitor instrument interface can acquire the status information of instruments from other systems.
23. The visitor instrument interface allows the user to enter a preprogrammed observing sequence and offset the telescope position and focus.
24. The telescope system provides a full telescope simulator to enable the astronomer to test observing programs for completeness, errors, and functionality.
25. The software system allowing for the interleaving of observing programs in a manner that is transparent to the individual observing programs, managing the collection of science, environmental, engineering, reference, and calibration data.
26. The system allows remote operations including both remote observing and remote telescope operation, It also covers remote eavesdropping, monitoring, configuration, and diagnosis.
27. Monitor's screen appears as a duplicate of that seen by the observer.
28. It allows the remote user to “pick and choose” the information that is displayed on the remote screen.
29. A remote observer can utilize as a real-time video and voice link with the operator in the control room.
30. A programming environment allows for the communication of special notes, instructions, and comments from the astronomer to the observer, possibly involving multimedia techniques.
31. The system must be able to switch during the night among telescope modes and instruments.
32. The users can transfer the control information to telescopes and instruments in the form of a specific format of commands and replies.
33.  The users can retransmit the commands in case of transmission error or collision, but the protocol has to be predictable in that commands cannot get lost and replies have to come back reliably.
34. The control information is explicitly required to be available to the Gemini 8m Telescopes software and is capable of being available to all users of the Gemini 8m Telescopes, subject only to restrictions with respect to updating.
35. The meteorological information coming from a weather station should be available centrally.
36. Astronomical data will have to be transported between GEMINI and the home institutes of visiting astronomers
37. Video information originates from target acquisition, guiding, and site monitoring cameras
38. Observing level allows a certain number of embedded tests, normally at a fairly high level. Monitoring is also done at this level.
39. All user categories have access to the observing level.
40. The operations and development staff can update maintenance tables (for example, with instrument parameters).
41. The operations and development staff can access the majority of parameters at the maintenance level.
42. Test level allows the installation and testing of new packages or new releases. Also, any low-level test can be performed in this mode.
43. It shall be possible to update all non-protected parameter values, i.e. those not used by operations at observing level.
44. Highly Permission must be granted to access this level.
45. The capacity of the system can be expressed in terms of nodes; each node will have the capability to run all operation levels.
46. The system must support off-site observing modes.
47. Reconfiguration procedures must exist, to change the observing environment.
48. Operations staff have privileges to change the environment, meaning selecting a suitable combination of instruments.



### Non-functional requirements
1. Only specific users can have access to a certain access mode.
2. Monitoring, testing, and administrative access shall not affect the performance of ongoing observations.
3. User interfaces must be simple, controls grouped for convenience of observation activity, organized for ease of control, and quick response to unsafe conditions.
4. User interfaces for different access levels should be uniform across all subsystems, though different access levels should present different ‘look-and-feels’.
5. The existence of the scheduling queue shall be transparent to the on-site observer during the initial phases of telescope operation. Only after experience has been gained with the system will the existence of the queue become evident to the on-site observer. 
6. Any subsection of the whole Gemini 8m Telescopes system should be accessible and controllable from any single point.
7. All software will be maintained under a version control system.
8. The visitor instrument interface should be a subset of the existing instrumentation interface (rather than a separate system).
9. The visitor instrument interface may support coordinate transforms between visitor instrument and the Gemini system, archiving of visitor instrument data, and maintenance of operations tables.
10. The complicated functionality will be supported via standardized interface.
11. The visitor instrument interface should be stable and long-lived.
12. Interactive observing with time allocation for full nights
13. The interface should be a visually-oriented environment providing a simple, easy-to-use to the astronomer.
14. It must be possible to queue all of the observing that is possible with the currently available instruments
15. All software should be developed to permit remote operations. There should be no conceptual difference between software working on-site and remotely.
16. Team observing, with multiple observers at different sites should be supported.
17.  It must be possible to restrict specific operations to specific remote sites. For example, at the Mauna Kea site, remote telescope control might be restricted to Hale Pohaku.
18. Remote monitoring should not have any effects on the local user's environment.
19. It is necessary to back up local users' expertise and to help in case of problems while all systems are operating.
20. The observing program must be automated.
21. It should be available both to the astronomer for developing the program, and to the observer in a shared environment.
22.  The support structure for communicating commands must be reliable, with a uniform ACK/NAK protocol adopted across all systems. Timeouts must be supported at approximately 500 msec.
23. Handshaking of commands between IOCs must occur within 100-200 msec, signaling acceptance of each command.
24. Peak control information within the system is expected to be 100 TPS.
25. The control information delay times must stay within precise limits
26. The request for control information cannot produce a delay of control activities or locking, even if the corresponding equipment is not available or faulty.
27. The control information is available to the Gemini 8m Telescopes software and to all users of the Gemini 8m Telescopes, subject only to restrictions with respect to updating.
28. Maximum acceptable readout time for detector data is very dependent on detector type and size as well as the intended application 1. For focusing and related activities, maximum acceptable detector readout time is about 0.1 sec 2. . For mosaicked, large optical detectors, a full readout of the detector must be done in about 2 or 3 minutes.
29. Data from all instruments and detectors is stored as compressed data, using a standard format.
30. The system data capacity is capable of retaining 7 days of data produced by the largest instrument, the last 3 days of which must be available interactively from hard disk or similar medium.
31. The operational overheads of the astronomical data flow be kept as low as possible, to maximize actual observing times
32. The link chosen to transfer data should represent as small a bottleneck as possible for data acquisition.
33. The system must allow for fast transmission of rough images every 0.5 sec. This may be assisted through the use of data-loss compression techniques (e.g. JPEG, MPEG, etc).
34. This high-quality transmission must require less than 20 sec, and can only be assisted with loss-less compression.
35. No hard restrictions on the number of simultaneous users, but should allow for policy decisions that do restrict the amount of simultaneous access.
36. Every command must be accepted/rejected within 2 sec and before the corresponding action occurs.
37. Status display update must be within 4 sec at the local stations.
38. Requests of subsystems for status information must be answered within 5 sec and be possible in maintenance level operation.
39. All software bugs should be logged and then fixed as soon as possible after detection.
40. This notification must be specific as to origin and problem.
41. It may have multiple levels of fault notification such as detailed, verbose, short, etc. to aid in tracking down problems.
42. All communication shall be based on the use of standard communication protocols
43. All telescope, instrument, and detector control information is to be available at any operational level.
44. Access times to the database are to be in the range of 2-3 msec per access.
45. Asynchronous writes are to be supported, allowing for concurrent operation.
46. Time-access critical information is available in memory.
47. The database must support both remote access and distributed data via the WAN to remote sites.
48. Astronomical data is automatically stored onto the Archive medium.
49. Star catalogs are available in Astronomical object catalogs
50. Telescope and instrument parameters are distributed in databases across the IOCs.
51. All additional data that is not required on line are stored in a relational DBMS.
52. Observing commands for providing information on the course of operation and trigger events.
53. Start-up and shut-down procedures should take 10-14 minutes.
54. All start-ups and shut-downs are to be automatically logged with time stamps.
55. System logging information should include all important events, properly timestamped and indexed.
56. It must be possible to log engineering data at up to 200 Hz rates for short periods of time.
57. Long-term logging of engineering data must be possible at 1 Hz or less.
58. The time-stamp error logging should provide enough information to trace the condition back to its apparent source.
59. Errors that result in an "alarm" should be described, along with the proper action required.
60. Command retries must be included in the system for most common timeouts or no response conditions.
61. The number of warnings should be small by monitoring the rate of warning messages.
62. Failure conditions should not cascade.
63. The operational software should check the compatibility between subsystems in different modes.
64. The Gemini 8m Telescopes computers and software shall be capable of coping with the load of 10 active nodes, should the case arise.
65. There must be automatic procedures to implement startup and shutdown of the telescope and instruments. These must allow startup and shutdown of instruments independently of the telescope and without affecting the telescope operation.
66. The definition of the observing environments must be dynamic i.e. feasible during operations without the need to restart everything.
67. The operational software should know which subsystems are installed and operational at any given time.
68. The user interface must be homogeneous, which can be achieved only by applying the same user interface tools to the whole project
69. The user interface should rather be seen as a package to be callable from a large number of stations, depending on where a user is. It should also be network transparent so that it does not matter where it is being run.
70. The user interface tools shall be based on standards, which will be portable across different computer hardware platforms.
